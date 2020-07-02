package com.ivo.rakar.foodapp.consumerservice.web.models;

public class CreateConsumerResponse {

    private long consumerId;

    public CreateConsumerResponse(long consumerId) {
        this.consumerId = consumerId;
    }

    public long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(long consumerId) {
        this.consumerId = consumerId;
    }
}
