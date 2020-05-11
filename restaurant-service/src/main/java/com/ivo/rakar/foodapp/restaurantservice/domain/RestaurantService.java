package com.ivo.rakar.foodapp.restaurantservice.domain;

import com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant;
import com.ivo.rakar.foodapp.restaurantservice.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.restaurantservice.web.models.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant create(CreateRestaurantRequest request) {
        Restaurant restaurant = new Restaurant(request.getName(), request.getLocation(), request.getMenu());
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public List<Restaurant> getAll() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    public Optional<Restaurant> get(long id) {
        return restaurantRepository.findById(id);
    }
}
