package com.ivo.rakar.foodapp.restaurantservice.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan
public class RestaurantConfiguration {
    @Bean
    public RestaurantService restaurantService() {
        return new RestaurantService();
    }
}
