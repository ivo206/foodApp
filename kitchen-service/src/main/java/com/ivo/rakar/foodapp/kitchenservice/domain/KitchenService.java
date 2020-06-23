package com.ivo.rakar.foodapp.kitchenservice.domain;

import com.ivo.rakar.foodapp.kitchenservice.domain.exceptions.RestaurantNotFoundException;
import com.ivo.rakar.foodapp.kitchenservice.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.restaurantservice.events.Menu;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class KitchenService {
    private RestaurantRepository restaurantRepository;

    public KitchenService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void createRestaurant(long id, String restaurantName, Menu menu) {
        Restaurant restaurant = new Restaurant(id, restaurantName, menu.getItems());
        restaurantRepository.save(restaurant);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateMenu(long id, String restaurantName, Menu menu) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
        restaurant.setName(restaurantName);
        restaurant.setMenu(menu.getItems());
        restaurantRepository.save(restaurant);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void deleteMenu(long id) {
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }


}
