package com.scaffolding.scaffolding.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "passwords")
public class Password {

    @Id
    @Column(name = "id")
    private UUID id;


    @Column(name = "value")
    private String value = UUID.randomUUID().toString();

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Password() {
    }

    public Password(UUID id, String value, Customer customer) {
        this.id = id;
        this.value = value;
        this.customer = customer;
    }

    public Password(Customer customer) {
        setId(UUID.randomUUID());
        setValue(UUID.randomUUID().toString());
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
