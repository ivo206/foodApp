package com.ivo.rakar.foodapp.orderservice.domain.models;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class MenuItem {

    private String id;
    private String itemName;
    private Money price;
    private String itemDescription;

    public MenuItem() {
    }

    public MenuItem(String id, String itemName, Money price, String itemDescription) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.itemDescription = itemDescription;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
