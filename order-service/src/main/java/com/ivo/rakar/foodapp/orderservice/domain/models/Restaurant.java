package com.ivo.rakar.foodapp.orderservice.domain.models;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "order_service_restaurants")
@Access(AccessType.FIELD)
public class Restaurant {

    @Id
    private Long id;
    private String name;

    @Embedded
    @ElementCollection
    @CollectionTable()
    private List<MenuItem> menu;

    public Restaurant(Long id, String name, List<MenuItem> menu) {
        this.id = id;
        this.name = name;
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

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public Optional<MenuItem> findMenuItem(String itemId){
        return menu.stream().filter(mi -> mi.getId().equals(itemId)).findFirst();
    }

}