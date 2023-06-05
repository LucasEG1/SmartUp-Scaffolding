package com.scaffolding.scaffolding.entity;

import java.util.UUID;

public class LoginBean {

    private String dni;

    private UUID password;

    public LoginBean(String dni, UUID password) {
        this.dni = dni;
        this.password = password;
    }

    public LoginBean() {
    }

    public String getDni() {
        return dni;
    }

    public UUID getPassword() {
        return password;
    }
}
