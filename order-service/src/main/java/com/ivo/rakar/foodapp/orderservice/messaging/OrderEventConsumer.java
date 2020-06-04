package com.ivo.rakar.foodapp.orderservice.messaging;

import com.ivo.rakar.foodapp.orderservice.domain.OrderService;
import com.ivo.rakar.foodapp.restaurantservice.events.Menu;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantCreated;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

public class OrderEventConsumer {
    private OrderService orderService;

    public OrderEventConsumer(OrderService orderService) {
        this.orderService = orderService;
    }

    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder
                .forAggregateType("com.ivo.rakar.foodapp.restaurantservice.domain.models.Restaurant")
                .onEvent(RestaurantCreated.class, this::createMenu)
                .build();
    }

    private void createMenu(DomainEventEnvelope<RestaurantCreated> de) {
        String restaurantIds = de.getAggregateId();
        long id = Long.parseLong(restaurantIds);
        Menu menu = de.getEvent().getMenu();
        //orderService.createMenu(id, de.getEvent().getName(), menu);
    }
}
