package com.ivo.rakar.foodapp.restaurantservice.events;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class MenuItem {
    private String id;
    private String description;
    private double rating;
    private double price;
    private String name;

    public MenuItem() {
    }

    public MenuItem(String id, String description, double price, String name) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
