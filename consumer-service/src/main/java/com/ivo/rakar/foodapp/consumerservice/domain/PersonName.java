package com.ivo.rakar.foodapp.consumerservice.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PersonName {

    private String surname;
    private String name;

    public PersonName(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    private PersonName() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
