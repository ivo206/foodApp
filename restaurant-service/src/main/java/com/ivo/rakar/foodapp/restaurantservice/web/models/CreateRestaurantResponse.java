package com.ivo.rakar.foodapp.restaurantservice.web.models;

public class CreateRestaurantResponse {

    private long id;

    public CreateRestaurantResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CreateRestaurantResponse(long id) {
        this.id = id;
    }
}
