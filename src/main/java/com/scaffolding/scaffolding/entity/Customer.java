package com.scaffolding.scaffolding.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
public class Customer {

    @Id
    @JsonIgnore
    private UUID id;

    @NotBlank(message = "Name must be provided")
    private String name;

    @NotBlank(message = "Surname must be provided")
    private String surname;

    @NotBlank(message = "DNI must be provided")
    @Pattern(regexp = "[XYZ]?([0-9]{7,8})([A-Z])", message = "invalid DNI: Check regex")
    private String dni;


    @Column(name = "birth_date")
    private String birthDate;
    private String address;

    @Column(name = "zip_code")
    private String zipCode;
    private String email;

    public Customer() {
    }

    public Customer(String name, String surname, String dni, String birthDate, String address, String zipCode, String email, Password password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.birthDate = birthDate;
        this.address = address;
        this.zipCode = zipCode;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

