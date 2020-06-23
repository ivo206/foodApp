package com.ivo.rakar.foodapp.kitchenservice.messaging;

import com.ivo.rakar.foodapp.kitchenservice.domain.KitchenService;
import com.ivo.rakar.foodapp.restaurantservice.events.Menu;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantCreated;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantDeleted;
import com.ivo.rakar.foodapp.restaurantservice.events.RestaurantUpdated;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

public class KitchenEventConsumer {

    private KitchenService kitchenService;

    public KitchenEventConsumer(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
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
        kitchenService.createRestaurant(id, restaurantName, menu);
    }

    private void updateMenu(DomainEventEnvelope<RestaurantUpdated> de) {
        String restaurantIds = de.getAggregateId();
        long id = Long.parseLong(restaurantIds);
        Menu menu = de.getEvent().getMenu();
        String restaurantName = de.getEvent().getName();
        kitchenService.updateMenu(id, restaurantName, menu);
    }

    private void deleteMenu(DomainEventEnvelope<RestaurantDeleted> de) {
        String restaurantIds = de.getAggregateId();
        long id = Long.parseLong(restaurantIds);
        kitchenService.deleteMenu(id);
    }
}
