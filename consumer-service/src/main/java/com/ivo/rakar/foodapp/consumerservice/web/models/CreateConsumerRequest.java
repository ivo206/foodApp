package com.ivo.rakar.foodapp.consumerservice.web.models;

import com.ivo.rakar.foodapp.consumerservice.domain.PersonName;

public class CreateConsumerRequest {
    private PersonName personName;

    public CreateConsumerRequest(PersonName personName) {
        this.personName = personName;
    }

    public PersonName getPersonName() {
        return personName;
    }

    public void setPersonName(PersonName personName) {
        this.personName = personName;
    }

    private CreateConsumerRequest() {
    }
}
