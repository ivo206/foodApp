package com.ivo.rakar.foodapp.kitchenservice.web.models;

import com.ivo.rakar.foodapp.kitchenservice.domain.Restaurant;

import java.util.List;

public class GetAllRestaurantsResponse {

    private List<Restaurant> restaurants;

    public GetAllRestaurantsResponse(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }



}
