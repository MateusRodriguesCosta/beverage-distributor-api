package com.beverage_app.beverage_distributor_api.exceptions;

public class PedidoQuantidadeInsuficienteException extends RuntimeException {
    public PedidoQuantidadeInsuficienteException(String message) {
        super(message);
    }
}
