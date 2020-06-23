package com.ivo.rakar.foodapp.kitchenservice.domain.repositories;

import com.ivo.rakar.foodapp.kitchenservice.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
