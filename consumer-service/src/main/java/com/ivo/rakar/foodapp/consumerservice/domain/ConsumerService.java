package com.ivo.rakar.foodapp.consumerservice.domain;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class ConsumerService {

    ConsumerRepository consumerRepository;
    DomainEventPublisher domainEventPublisher;

    public ConsumerService(ConsumerRepository consumerRepository, DomainEventPublisher domainEventPublisher) {
        this.consumerRepository = consumerRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public ResultWithEvents<Consumer> create(PersonName personName) {
        ResultWithEvents<Consumer> consumerWithEvents = Consumer.create(personName);
        consumerRepository.save(consumerWithEvents.result);
        domainEventPublisher.publish(Consumer.class, consumerWithEvents.result.getId(), consumerWithEvents.events);
        return consumerWithEvents;
    }

    public Optional<Consumer> findById(long id) {
        return consumerRepository.findById(id);
    }

}
