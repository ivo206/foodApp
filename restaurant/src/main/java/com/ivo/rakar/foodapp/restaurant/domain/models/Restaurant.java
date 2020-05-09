package com.ivo.rakar.foodapp.restaurant.domain.models;

import javax.persistence.*;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Embedded
    private Location location;
    private double rating;
    @Embedded
    private Menu menu;

    public Restaurant() {
    }

    public Restaurant(String name, Location location, Menu menu) {
        this.name = name;
        this.location = location;
        this.menu = menu;
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
