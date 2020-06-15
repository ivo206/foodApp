package com.ivo.rakar.foodapp.orderservice.messaging;

import com.ivo.rakar.foodapp.orderservice.domain.OrderService;
import com.ivo.rakar.foodapp.restaurantservice.events.Menu;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantCreated;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantDeleted;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantUpdated;
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
                .onEvent(RestaurantUpdated.class, this::updateMenu)
                .onEvent(RestaurantDeleted.class, this::deleteMenu)
                .build();
    }

    private void createMenu(DomainEventEnvelope<RestaurantCreated> de) {
        String restaurantIds = de.getAggregateId();
        long id = Long.parseLong(restaurantIds);
        Menu menu = de.getEvent().getMenu();
        String restaurantName = de.getEvent().getName();
        orderService.createMenu(id, restaurantName, menu);
    }

    private void updateMenu(DomainEventEnvelope<RestaurantUpdated> de) {
        String restaurantIds = de.getAggregateId();
        long id = Long.parseLong(restaurantIds);
        Menu menu = de.getEvent().getMenu();
        String restaurantName = de.getEvent().getName();
        orderService.updateMenu(id, restaurantName, menu);
    }

    private void deleteMenu(DomainEventEnvelope<RestaurantDeleted> de) {
        String restaurantIds = de.getAggregateId();
        long id = Long.parseLong(restaurantIds);
        orderService.deleteMenu(id);
    }
}
