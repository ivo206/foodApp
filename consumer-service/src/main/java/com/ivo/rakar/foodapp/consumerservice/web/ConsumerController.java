package com.ivo.rakar.foodapp.consumerservice.web;

import com.ivo.rakar.foodapp.consumerservice.domain.Consumer;
import com.ivo.rakar.foodapp.consumerservice.domain.ConsumerService;
import com.ivo.rakar.foodapp.consumerservice.web.models.CreateConsumerRequest;
import com.ivo.rakar.foodapp.consumerservice.web.models.CreateConsumerResponse;
import com.ivo.rakar.foodapp.consumerservice.web.models.GetConsumerResponse;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/consumers")
public class ConsumerController {

    private ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @PostMapping
    public CreateConsumerResponse create(@RequestBody CreateConsumerRequest request) {
        ResultWithEvents<Consumer> result = consumerService.create(request.getPersonName());
        return new CreateConsumerResponse(result.result.getId());
    }

    @GetMapping(path="/{consumerId}")
    public ResponseEntity<GetConsumerResponse> get(@PathVariable long consumerId) {
        return consumerService.findById(consumerId)
                .map(consumer -> new ResponseEntity<>(new GetConsumerResponse(consumer.getPersonName()), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
