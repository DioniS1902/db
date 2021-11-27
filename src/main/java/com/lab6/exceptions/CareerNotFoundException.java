package com.lab6.exceptions;

public class CareerNotFoundException extends RuntimeException {
    public CareerNotFoundException(String message) {
        super(message);
    }

    public CareerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
