package com.beverage_app.beverage_distributor_api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PedidoClienteDTO {
    private Long id;
    private Long clienteId;
    private List<ItemPedidoDTO> itens;
}
