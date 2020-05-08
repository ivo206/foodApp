package com.ivo.rakar.foodapp.restaurant.web;

import com.ivo.rakar.foodapp.restaurant.domain.RestaurantService;
import com.ivo.rakar.foodapp.restaurant.domain.models.Restaurant;
import com.ivo.rakar.foodapp.restaurant.web.models.CreateRestaurantRequest;
import com.ivo.rakar.foodapp.restaurant.web.models.CreateRestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(method = RequestMethod.POST)
    public CreateRestaurantResponse create(@RequestBody CreateRestaurantRequest request) {
        Restaurant restaurant = restaurantService.create(request);
        return new CreateRestaurantResponse(restaurant.getId());
    }
}
