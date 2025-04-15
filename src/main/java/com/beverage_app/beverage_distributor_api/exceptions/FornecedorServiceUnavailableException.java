package com.beverage_app.beverage_distributor_api.exceptions;

public class FornecedorServiceUnavailableException extends RuntimeException {
    public FornecedorServiceUnavailableException(String message, Throwable cause) {
        super(message);
    }
    public FornecedorServiceUnavailableException(String message) {}
}
