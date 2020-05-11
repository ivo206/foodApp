package com.ivo.rakar.foodapp.restaurantservice.web.models;

import com.ivo.rakar.foodapp.restaurantservice.domain.models.Location;
import com.ivo.rakar.foodapp.restaurantservice.domain.models.Menu;
import com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant;

public class GetRestaurantResponse {

    private Long id;
    private String name;
    private Location location;
    private double rating;
    private Menu menu;

    public GetRestaurantResponse(Restaurant restaurant) {
        if(restaurant != null) {
            this.name = restaurant.getName();
            this.location = restaurant.getLocation();
            this.menu = restaurant.getMenu();
            this.rating = restaurant.getRating();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
