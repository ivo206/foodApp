package com.ivo.rakar.foodapp.orderservice.web;

import com.ivo.rakar.foodapp.orderservice.domain.OrderService;
import com.ivo.rakar.foodapp.orderservice.domain.models.MenuItemIdAndQuantity;
import com.ivo.rakar.foodapp.orderservice.domain.models.Order;
import com.ivo.rakar.foodapp.orderservice.web.models.CreateOrderRequest;
import com.ivo.rakar.foodapp.orderservice.web.models.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public CreateOrderResponse creteOrder(@RequestBody CreateOrderRequest request) {
        Order order = orderService.create(request.getCustomerId(),
                request.getRestaurantId(),
                request.getLineItems().stream()
                        .map(li -> new MenuItemIdAndQuantity(li.getMenuItemId(), li.getQuantity()))
                        .collect(Collectors.toList()));

        return new CreateOrderResponse(1);
    }

}
