package com.ivo.rakar.foodapp.orderservice.domain;

import com.ivo.rakar.foodapp.orderservice.domain.models.*;
import com.ivo.rakar.foodapp.orderservice.domain.models.exceptions.OrderItemNotFoundException;
import com.ivo.rakar.foodapp.orderservice.domain.models.exceptions.RestaurantNotFoundException;
import com.ivo.rakar.foodapp.orderservice.domain.repositories.OrderRepository;
import com.ivo.rakar.foodapp.orderservice.domain.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

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
            return new OrderLineItem(li.getMenuItemId(), m.getItemName(), m.getPrice(), li.getQuantity());
        }).collect(Collectors.toList());
    }

}
