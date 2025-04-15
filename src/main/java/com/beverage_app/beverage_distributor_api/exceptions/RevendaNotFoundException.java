package com.beverage_app.beverage_distributor_api.exceptions;

public class RevendaNotFoundException extends RuntimeException {
    public RevendaNotFoundException(String message) {
        super(message);
    }
}
