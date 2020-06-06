package com.ivo.rakar.foodapp.orderservice.domain;


import com.ivo.rakar.foodapp.orderservice.domain.repositories.OrderRepository;
import com.ivo.rakar.foodapp.orderservice.domain.repositories.RestaurantRepository;
import com.ivo.rakar.foodapp.orderservice.messaging.OrderEventConsumer;
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
public class OrderServiceConfiguration {

    @Bean
    public OrderService orderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        return new OrderService(orderRepository, restaurantRepository);
    }

    @Bean
    public OrderEventConsumer orderEventConsumer(OrderService orderService) {
        return new OrderEventConsumer(orderService);
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(OrderEventConsumer orderEventConsumer, DomainEventDispatcherFactory domainEventDispatcherFactory) {
        return domainEventDispatcherFactory.make("orderServiceEvents", orderEventConsumer.domainEventHandlers());
    }
}
