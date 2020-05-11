package com.ivo.rakar.foodapp.restaurantservice.web.models;

import com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant;

import java.util.List;

public class GetAllRestaurantResponse {

    private List<Restaurant> restaurants;

    public GetAllRestaurantResponse() {
    }

    public GetAllRestaurantResponse(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

}
