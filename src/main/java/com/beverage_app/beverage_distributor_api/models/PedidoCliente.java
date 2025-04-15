package com.beverage_app.beverage_distributor_api.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoCliente extends Pedido {
    @NotNull(message = "Identificação do cliente é obrigatória")
    private Long clienteId;
}
