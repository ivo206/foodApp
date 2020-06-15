package com.ivo.rakar.foodapp.restaurantservice.domain;

import com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant;
import com.ivo.rakar.foodapp.restaurantservice.domain.models.RestaurantNotFoundException;
import com.ivo.rakar.foodapp.restaurantservice.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantCreated;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantDeleted;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantUpdated;
import com.ivo.rakar.foodapp.restaurantservice.web.models.CreateRestaurantRequest;
import com.ivo.rakar.foodapp.restaurantservice.web.models.UpdateRestaurantRequest;
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
        Restaurant restaurant = new Restaurant(request.getName(), request.getLocation(), request.getMenu());
        restaurantRepository.save(restaurant);
        domainEventPublisher.publish(Restaurant.class, restaurant.getId(), Collections.singletonList(new RestaurantCreated(request.getName(), request.getMenu())));
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

    public Restaurant update(long id, UpdateRestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
        restaurant.setName(request.getName());
        restaurant.setMenu(request.getMenu());
        restaurant.setLocation(request.getLocation());
        restaurantRepository.save(restaurant);
        domainEventPublisher.publish(Restaurant.class, restaurant.getId(), Collections.singletonList(new RestaurantUpdated(restaurant.getName(), restaurant.getMenu())));
        return restaurant;
    }

    public void delete(long id) {
        restaurantRepository.deleteById(id);
        domainEventPublisher.publish(Restaurant.class, Long.valueOf(id), Collections.singletonList(new RestaurantDeleted()));
    }
}
