package com.monycell.edu.citizenapp.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "indegines")
public final class Indigene {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long indigeneId;

    @Embedded
    private Contact contact;

    //@Valid
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "address1", column = @Column(name = "homeAddress")),
            @AttributeOverride(name = "address2", column = @Column(name = "houseAddress"))
    })
    private Address address;

    public Indigene() {
    }

    public Indigene(Contact contact, Address address) {
        this.contact = contact;
        this.address = address;
    }

    public Long getIndigeneId() {
        return indigeneId;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
}
