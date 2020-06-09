package com.ivo.rakar.foodapp.restaurantservice.domain.models;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(long restaurantId) {
        super("Restaurant not found with id " + restaurantId);
    }
}
