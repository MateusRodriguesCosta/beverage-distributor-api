package com.beverage_app.beverage_distributor_api.dtos;

import lombok.Data;

@Data
public class PedidoFornecedorRequestDTO {
    private PedidoFornecedorDTO pedidoFornecedor;
    private RevendaDTO revenda;
}
