package com.ivo.rakar.foodapp.restaurantservice.events;

import io.eventuate.tram.events.common.DomainEvent;

public class RestaurantCreated implements DomainEvent {
    private String name;
    private Menu menu;

    public String getName() {
        return name;
    }

    private RestaurantCreated() {
    }

    public RestaurantCreated(String name, Menu menu) {
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
