package com.ivo.rakar.foodapp.kitchenservice.domain.exceptions;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException(long id) {
        super("Restaurant not found:" + id);
    }
}
