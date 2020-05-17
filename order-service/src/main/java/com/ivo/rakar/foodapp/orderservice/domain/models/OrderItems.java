package com.ivo.rakar.foodapp.orderservice.domain.models;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class OrderItems {

    @ElementCollection
    @CollectionTable(name = "order_line_items")
    private List<OrderLineItem> orderLineItems;

    public OrderItems(List<OrderLineItem> menuItems) {
        this.orderLineItems = menuItems;
    }

    public List<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }


}
