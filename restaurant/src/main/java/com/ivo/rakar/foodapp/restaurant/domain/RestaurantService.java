package com.ivo.rakar.foodapp.restaurant.domain;

import com.ivo.rakar.foodapp.restaurant.domain.models.Restaurant;
import com.ivo.rakar.foodapp.restaurant.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.restaurant.web.models.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant create(CreateRestaurantRequest request) {
        Restaurant restaurant = new Restaurant(request.getName(), request.getLocation(), request.getMenu());
        restaurantRepository.save(restaurant);
        return restaurant;
    }
}
