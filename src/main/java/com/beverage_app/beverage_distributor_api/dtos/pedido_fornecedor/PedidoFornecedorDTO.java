package com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor;

import com.beverage_app.beverage_distributor_api.dtos.ItemPedidoDTO;
import lombok.Data;

import java.util.List;

@Data
public class PedidoFornecedorDTO {
    private Long id;
    private List<ItemPedidoDTO> itens;
}
