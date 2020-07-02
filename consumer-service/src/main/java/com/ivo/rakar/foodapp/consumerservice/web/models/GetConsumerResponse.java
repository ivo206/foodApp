package com.ivo.rakar.foodapp.consumerservice.web.models;

import com.ivo.rakar.foodapp.consumerservice.domain.PersonName;

public class GetConsumerResponse {
    private PersonName personName;

    public GetConsumerResponse(PersonName personName) {
        this.personName = personName;
    }

    public PersonName getPersonName() {
        return personName;
    }
}
