package com.ivo.rakar.foodapp.orderservice.web.models;

import java.util.List;

public class CreateOrderRequest {
    private long restaurantId;
    private long customerId;
    private List<LineItem> lineItems;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(long restaurantId, long customerId, List<LineItem> lineItems) {
        this.restaurantId = restaurantId;
        this.customerId = customerId;
        this.lineItems = lineItems;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
