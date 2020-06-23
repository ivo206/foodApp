package com.ivo.rakar.foodapp.kitchenservice.domain;

import com.ivo.rakar.foodapp.kitchenservice.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.kitchenservice.messaging.KitchenEventConsumer;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory;
import io.eventuate.tram.spring.consumer.kafka.EventuateTramKafkaMessageConsumerConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration;
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan
@Import({TramEventsPublisherConfiguration.class, EventuateTramKafkaMessageConsumerConfiguration.class, TramMessageProducerJdbcConfiguration.class, TramEventSubscriberConfiguration.class})
public class KitchenServiceConfiguration {
    @Bean
    public KitchenService kitchenService(RestaurantRepository restaurantRepository) {
        return new KitchenService(restaurantRepository);
    }

    @Bean
    public KitchenEventConsumer orderEventConsumer(KitchenService orderService) {
        return new KitchenEventConsumer(orderService);
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(KitchenEventConsumer kitchenEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
        return domainEventDispatcherFactory.make("kitchenServiceEvents", kitchenEventConsumer.domainEventHandlers());
    }
}
