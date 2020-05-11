package com.ivo.rakar.foodapp.restaurantservice.domain.repositories;

import com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
}
