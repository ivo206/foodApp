package com.ivo.rakar.foodapp.orderservice.domain.models;

import javax.persistence.*;
import java.util.List;

import static com.ivo.rakar.foodapp.orderservice.domain.models.OrderState.APPROVAL_PENDING;

@Entity
@Table(name = "orders")
@Access(AccessType.FIELD)
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;

    @Embedded
    private OrderItems orderItems;
    private long restaurantId;
    private long consumerId;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    @Embedded
    private DeliveryInformation deliveryInformation;
    @Embedded
    private PaymentInformation paymentInformation;

    public Order() {
    }

    public Order(List<OrderLineItem> orderItems, long restaurantId, long consumerId) {
        this.orderItems = new OrderItems(orderItems);
        this.restaurantId = restaurantId;
        this.consumerId = consumerId;
        this.orderState = APPROVAL_PENDING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
