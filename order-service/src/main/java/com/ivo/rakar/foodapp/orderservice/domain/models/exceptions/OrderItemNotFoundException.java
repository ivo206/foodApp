package com.ivo.rakar.foodapp.orderservice.domain.models.exceptions;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(String orderItemId) {
        super("Invalid menu item id " + orderItemId);
    }
}