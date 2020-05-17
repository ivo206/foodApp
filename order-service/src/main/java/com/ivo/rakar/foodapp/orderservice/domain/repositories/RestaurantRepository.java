package com.ivo.rakar.foodapp.orderservice.domain.repositories;

import com.ivo.rakar.foodapp.orderservice.domain.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
