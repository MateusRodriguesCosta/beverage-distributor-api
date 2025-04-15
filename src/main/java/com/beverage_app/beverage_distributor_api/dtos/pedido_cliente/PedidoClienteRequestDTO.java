package com.beverage_app.beverage_distributor_api.dtos.pedido_cliente;

import com.beverage_app.beverage_distributor_api.dtos.ItemPedidoDTO;
import lombok.Data;

import java.util.List;

@Data
public class PedidoClienteRequestDTO {
    private Long clienteId;
    private List<ItemPedidoDTO> itens;
}
