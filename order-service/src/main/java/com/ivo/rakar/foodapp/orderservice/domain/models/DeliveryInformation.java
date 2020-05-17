package com.ivo.rakar.foodapp.orderservice.domain.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Access(AccessType.FIELD)
public class DeliveryInformation {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="state", column=@Column(name="delivery_state"))
    })
    private Address address;
    private LocalDateTime deliveryTime;
}
