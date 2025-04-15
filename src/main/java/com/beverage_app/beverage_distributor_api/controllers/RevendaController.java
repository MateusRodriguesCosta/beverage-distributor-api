package com.beverage_app.beverage_distributor_api.controllers;

import com.beverage_app.beverage_distributor_api.dtos.CadastroRevendaDTO;
import com.beverage_app.beverage_distributor_api.services.RevendaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/revenda")
public class RevendaController {

    private final RevendaService revendaService;

    public RevendaController(RevendaService revendaService) {
        this.revendaService = revendaService;
    }

    @PostMapping
    public ResponseEntity<CadastroRevendaDTO> createRevenda(@RequestBody @Valid CadastroRevendaDTO revendaDTO) {
        CadastroRevendaDTO createdRevenda = revendaService.createRevenda(revendaDTO);
        return ResponseEntity.ok(createdRevenda);
    }
}
