package com.ivo.rakar.foodapp.orderservice.domain.models.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(long restaurantId) {
        super("Restaurant not found with id " + restaurantId);
    }
}
