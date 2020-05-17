package com.ivo.rakar.foodapp.orderservice.domain.repositories;

import com.ivo.rakar.foodapp.orderservice.domain.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
