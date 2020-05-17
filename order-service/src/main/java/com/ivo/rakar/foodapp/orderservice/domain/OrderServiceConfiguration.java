package com.ivo.rakar.foodapp.orderservice.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan
public class OrderServiceConfiguration {

    @Bean
    public OrderService restaurantService() {
        return new OrderService();
    }
}
