package com.ivo.rakar.foodapp.restaurantservice.web.models;

import com.ivo.rakar.foodapp.restaurantservice.domain.models.Location;
import com.ivo.rakar.foodapp.restaurantservice.events.Menu;

public class CreateRestaurantRequest {
    private String name;
    private Location location;
    private Menu menu;

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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
