package com.beverage_app.beverage_distributor_api.mappers;

import com.beverage_app.beverage_distributor_api.dtos.PedidoClienteDTO;
import com.beverage_app.beverage_distributor_api.models.PedidoCliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoClienteMapper {
    PedidoClienteDTO toPedidoClienteDTO(PedidoCliente pedidoCliente);
    PedidoCliente toPedidoCliente(PedidoClienteDTO pedidoClienteDTO);
}
