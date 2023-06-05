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
    private UUID value = UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Password() {
    }

    public Password(UUID id, UUID value, Customer customer) {
        this.id = id;
        this.value = value;
        this.customer = customer;
    }

    public Password(Customer customer) {
        setId(UUID.randomUUID());
        setValue(UUID.randomUUID());
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

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }
}
