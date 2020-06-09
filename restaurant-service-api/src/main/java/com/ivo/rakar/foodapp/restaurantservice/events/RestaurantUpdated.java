package com.ivo.rakar.foodapp.restaurantservice.events;

import io.eventuate.tram.events.common.DomainEvent;

public class RestaurantUpdated implements DomainEvent {
    private String name;
    private Menu menu;

    public String getName() {
        return name;
    }

    private RestaurantUpdated() {
    }

    public RestaurantUpdated(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setName(String name) {
        this.name = name;
    }
}
