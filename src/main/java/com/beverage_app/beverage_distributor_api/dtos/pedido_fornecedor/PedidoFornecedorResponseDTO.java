package com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor;

import com.beverage_app.beverage_distributor_api.dtos.ItemPedidoDTO;
import lombok.Data;

import java.util.List;

@Data
public class PedidoFornecedorResponseDTO {
    private List<ItemPedidoDTO> itens;
    private Long pedidoFornecedorId;
}
