package com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor;

import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaRequestDTO;
import lombok.Data;

@Data
public class PedidoFornecedorRequestDTO {
    private PedidoFornecedorDTO pedidoFornecedor;
    private RevendaRequestDTO revenda;
}
