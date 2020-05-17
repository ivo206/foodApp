package com.ivo.rakar.foodapp.orderservice.web.models;

public class CreateOrderResponse {
    private long orderId;

    public CreateOrderResponse() {
    }

    public CreateOrderResponse(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
