package com.beverage_app.beverage_distributor_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Identificação do cliente é obrigatória")
    private Long clienteId;

    @NotEmpty(message = "A lista de produtos não pode ser vazia")
    @OneToMany(mappedBy = "pedidoCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoCliente> itens = new ArrayList<>();

}
