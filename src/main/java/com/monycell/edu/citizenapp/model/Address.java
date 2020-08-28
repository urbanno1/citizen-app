package com.monycell.edu.citizenapp.model;

import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Address {

    //@NotBlank(message = "Home address can't be empty/null")
    private String address1;
    private String address2;
    private String zipCode;

    public Address() {
    }

    public Address(String address1, String zipCode) {
        this.address1 = address1;
        this.zipCode = zipCode;
    }

    public Address(String address1, String address2, String zipCode) {
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getZipCode() {
        return zipCode;
    }
}
