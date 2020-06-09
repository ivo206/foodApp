package com.ivo.rakar.foodapp.restaurantservice.web;

import com.ivo.rakar.foodapp.restaurantservice.domain.RestaurantService;
import com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant;
import com.ivo.rakar.foodapp.restaurantservice.domain.models.RestaurantNotFoundException;
import com.ivo.rakar.foodapp.restaurantservice.web.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping
    public CreateRestaurantResponse create(@RequestBody CreateRestaurantRequest request) {
        Restaurant restaurant = restaurantService.create(request);
        return new CreateRestaurantResponse(restaurant.getId());
    }

    @GetMapping
    public GetAllRestaurantResponse getAll() {
        List<Restaurant> restaurants = restaurantService.getAll();
        return new GetAllRestaurantResponse(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetRestaurantResponse> getRestaurant(@PathVariable long id) {
        return restaurantService.get(id)
                .map(r -> new ResponseEntity<>(new GetRestaurantResponse(r), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateRestaurantResponse> updateRestaurant(@PathVariable long id, @RequestBody UpdateRestaurantRequest request) {
        try {
            Restaurant restaurant = restaurantService.update(id, request);
            return new ResponseEntity<>(new UpdateRestaurantResponse(restaurant), HttpStatus.OK);
        }
        catch(RestaurantNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
