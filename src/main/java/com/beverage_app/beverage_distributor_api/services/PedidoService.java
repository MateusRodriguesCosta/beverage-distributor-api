package com.beverage_app.beverage_distributor_api.services;

import com.beverage_app.beverage_distributor_api.dtos.PedidoClienteDTO;
import com.beverage_app.beverage_distributor_api.mappers.PedidoClienteMapper;
import com.beverage_app.beverage_distributor_api.models.PedidoCliente;
import com.beverage_app.beverage_distributor_api.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PedidoClienteMapper pedidoClienteMapper;

    public PedidoService(PedidoRepository pedidoRepository,
                         PedidoClienteMapper pedidoClienteMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoClienteMapper = pedidoClienteMapper;
    }

    public PedidoClienteDTO createPedidoCliente(PedidoClienteDTO pedidoClienteDTO) {
        PedidoCliente pedidoCliente = pedidoClienteMapper.toPedidoCliente(pedidoClienteDTO);
        PedidoCliente savedPedidoCliente = pedidoRepository.save(pedidoCliente);
        return pedidoClienteMapper.toPedidoClienteDTO(savedPedidoCliente);
    }
}
