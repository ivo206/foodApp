package com.ivo.rakar.foodapp.restaurant.domain.repositories;

import com.ivo.rakar.foodapp.restaurant.domain.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
}
