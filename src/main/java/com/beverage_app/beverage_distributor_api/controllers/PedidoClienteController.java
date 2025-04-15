package com.beverage_app.beverage_distributor_api.controllers;

import com.beverage_app.beverage_distributor_api.dtos.PedidoClienteDTO;
import com.beverage_app.beverage_distributor_api.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidoCliente")
public class PedidoClienteController {

    private final PedidoService pedidoService;

    public PedidoClienteController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoClienteDTO> createPedidoCliente(@RequestBody @Valid PedidoClienteDTO pedidoClienteDTO) {
        PedidoClienteDTO createdPedidoCliente = pedidoService.createPedidoCliente(pedidoClienteDTO);
        return ResponseEntity.ok(createdPedidoCliente);
    }
}
