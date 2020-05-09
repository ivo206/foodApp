package com.ivo.rakar.foodapp.restaurant.web;

import com.ivo.rakar.foodapp.restaurant.domain.RestaurantService;
import com.ivo.rakar.foodapp.restaurant.domain.models.Restaurant;
import com.ivo.rakar.foodapp.restaurant.web.models.CreateRestaurantRequest;
import com.ivo.rakar.foodapp.restaurant.web.models.CreateRestaurantResponse;
import com.ivo.rakar.foodapp.restaurant.web.models.GetAllRestaurantResponse;
import com.ivo.rakar.foodapp.restaurant.web.models.GetRestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping
    public GetAllRestaurantResponse getAll() {
        List<Restaurant> restaurants = restaurantService.getAll();
        return new GetAllRestaurantResponse(restaurants);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<GetRestaurantResponse> getRestaurant(@PathVariable long id) {
        return restaurantService.get(id)
                .map(r -> new ResponseEntity<>(new GetRestaurantResponse(r), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
