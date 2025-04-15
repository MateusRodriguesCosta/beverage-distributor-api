package com.beverage_app.beverage_distributor_api.mappers;

import com.beverage_app.beverage_distributor_api.dtos.pedido_cliente.PedidoClienteRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.pedido_cliente.PedidoClienteResponseDTO;
import com.beverage_app.beverage_distributor_api.models.PedidoCliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoClienteMapper {
    PedidoClienteResponseDTO toPedidoClienteResponseDTO(PedidoCliente pedidoCliente);
    PedidoCliente toPedidoCliente(PedidoClienteRequestDTO pedidoClienteRequestDTO);
}
