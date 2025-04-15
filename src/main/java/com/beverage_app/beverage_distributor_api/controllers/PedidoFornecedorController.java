package com.beverage_app.beverage_distributor_api.controllers;

import com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor.PedidoFornecedorRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.pedido_fornecedor.PedidoFornecedorResponseDTO;
import com.beverage_app.beverage_distributor_api.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedidoFornecedor")
public class PedidoFornecedorController {

    private final PedidoService pedidoService;

    public PedidoFornecedorController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoFornecedorResponseDTO> createPedidoFornecedor(@RequestBody @Valid PedidoFornecedorRequestDTO pedidoFornecedorRequestDTO) {
        PedidoFornecedorResponseDTO pedidoFornecedorResponseDTO = pedidoService.createPedidoFornecedor(pedidoFornecedorRequestDTO);
        return ResponseEntity.ok(pedidoFornecedorResponseDTO);
    }
}
