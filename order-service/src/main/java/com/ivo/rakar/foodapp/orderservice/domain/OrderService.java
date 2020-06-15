package com.ivo.rakar.foodapp.orderservice.domain;

import com.ivo.rakar.foodapp.orderservice.domain.models.*;
import com.ivo.rakar.foodapp.orderservice.domain.models.exceptions.OrderItemNotFoundException;
import com.ivo.rakar.foodapp.orderservice.domain.models.exceptions.RestaurantNotFoundException;
import com.ivo.rakar.foodapp.orderservice.domain.repositories.OrderRepository;
import com.ivo.rakar.foodapp.orderservice.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.restaurantservice.events.Menu;
import com.ivo.rakar.foodapp.restaurantservice.events.MenuItem;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Transactional
public class OrderService {

    private OrderRepository orderRepository;

    private RestaurantRepository restaurantRepository;

    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void createMenu(long restaurantId, String name, Menu menu) {
        Restaurant restaurant = new Restaurant(restaurantId, name, menu.getItems());
        restaurantRepository.save(restaurant);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateMenu(long restaurantId, String name, Menu menu) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

        restaurant.setName(name);
        restaurant.setMenu(menu.getItems());
        restaurantRepository.save(restaurant);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteMenu(long restaurantId) {
        restaurantRepository.deleteById(restaurantId);
    }

    public Order create(long consumerId, long restaurantId, List<MenuItemIdAndQuantity> lineItems) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException(restaurantId));

        List<OrderLineItem> orderItems = createOrderItems(lineItems, restaurant);
        Order order = new Order(orderItems, restaurantId, consumerId);
        orderRepository.save(order);
        return order;
    }

    private List<OrderLineItem> createOrderItems(List<MenuItemIdAndQuantity> lineItems, Restaurant restaurant) {

        return lineItems.stream().map(li -> {
            MenuItem m = restaurant.findMenuItem(li.getMenuItemId())
                    .orElseThrow(() -> new OrderItemNotFoundException(li.getMenuItemId()));
            return new OrderLineItem(li.getMenuItemId(), m.getName(), m.getPrice(), li.getQuantity());
        }).collect(Collectors.toList());
    }

}
