package com.ivo.rakar.foodapp.restaurantservice.domain;

import com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant;
import com.ivo.rakar.foodapp.restaurantservice.domain.models.RestaurantCreated;
import com.ivo.rakar.foodapp.restaurantservice.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.restaurantservice.web.models.CreateRestaurantRequest;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    public Restaurant create(CreateRestaurantRequest request) {
        try{
            Restaurant restaurant = new Restaurant(request.getName(), request.getLocation(), request.getMenu());
            restaurantRepository.save(restaurant);
            domainEventPublisher.publish(Restaurant.class, restaurant.getId(), Collections.singletonList(new RestaurantCreated(request.getName(), request.getMenu())));
            return restaurant;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

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
