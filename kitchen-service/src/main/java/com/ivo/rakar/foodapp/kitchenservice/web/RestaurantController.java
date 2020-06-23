package com.ivo.rakar.foodapp.kitchenservice.web;

import com.ivo.rakar.foodapp.kitchenservice.domain.KitchenService;
import com.ivo.rakar.foodapp.kitchenservice.domain.Restaurant;
import com.ivo.rakar.foodapp.kitchenservice.web.models.GetAllRestaurantsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path="/restaurants")
public class RestaurantController {

    @Autowired
    KitchenService kitchenService;

    @GetMapping
    public GetAllRestaurantsResponse getAll(){
        List<Restaurant> restaurants = kitchenService.getAllRestaurants();
        return new GetAllRestaurantsResponse(restaurants);
    }
}
