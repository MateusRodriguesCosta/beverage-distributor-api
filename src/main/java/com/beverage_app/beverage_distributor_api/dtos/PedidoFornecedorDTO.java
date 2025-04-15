package com.beverage_app.beverage_distributor_api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PedidoFornecedorDTO {
    private Long id;
    private RevendaDTO revenda;
    private Long total;
    private List<ItemPedidoDTO> itens;
}
