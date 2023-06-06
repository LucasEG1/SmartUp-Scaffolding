package com.scaffolding.scaffolding.exception;

public class UnexistingCustomerException extends RuntimeException {

    public UnexistingCustomerException(String message) {
        super(message);
    }
}
