package com.ivo.rakar.foodapp.orderservice.domain.models;

import com.ivo.rakar.foodapp.restaurantservice.events.Money;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Embeddable
public class OrderLineItem {

    public OrderLineItem() {
    }

    private int quantity;
    private String menuItemId;
    private String name;

    //@Embedded
    //@AttributeOverrides(@AttributeOverride(name="amount", column=@Column(name="price")))
    private double price;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public OrderLineItem(String menuItemId, String name, double price, int quantity) {
        this.menuItemId = menuItemId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double deltaForChangedQuantity(int newQuantity) {
        return price * (newQuantity - quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    public double getTotal() {
        return price * (quantity);
    }
}
