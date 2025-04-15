package com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor;

import lombok.Data;

@Data
public class PedidoFornecedorResponseDTO {
    private PedidoFornecedorDTO pedidoFornecedor;
    private Long pedidoFornecedorId;
}
