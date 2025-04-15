package com.beverage_app.beverage_distributor_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID do produto é obrigatório")
    private Long id;

    @NotNull(message = "Quantidade é obrigatória")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "pedido_cliente_id", nullable = false)
    private PedidoCliente pedidoCliente;
}
