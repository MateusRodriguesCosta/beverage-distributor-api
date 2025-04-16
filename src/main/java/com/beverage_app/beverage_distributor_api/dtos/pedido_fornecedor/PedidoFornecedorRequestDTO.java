package com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor;

import com.beverage_app.beverage_distributor_api.dtos.ItemPedidoDTO;
import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaRequestDTO;
import lombok.Data;

import java.util.List;

@Data
public class PedidoFornecedorRequestDTO {
    private List<ItemPedidoDTO> itens;
    private RevendaRequestDTO revenda;
}
