package com.monycell.edu.citizenapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

    public String firstName;
    public String lastName;
    public Integer age;

    public Contact () {
    }

    public Contact(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }
}
