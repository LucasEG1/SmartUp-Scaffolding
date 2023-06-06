package com.scaffolding.scaffolding.entity;

public class LoginBean {

    private String dni;

    private String password;

    public LoginBean(String dni, String password) {
        this.dni = dni;
        this.password = password;
    }

    public LoginBean() {
    }

    public String getDni() {
        return dni;
    }

    public String getPassword() {
        return password;
    }
}
