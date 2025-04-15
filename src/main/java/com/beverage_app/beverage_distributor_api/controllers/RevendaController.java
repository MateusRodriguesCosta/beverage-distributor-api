package com.beverage_app.beverage_distributor_api.controllers;

import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaResponsetDTO;
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
    public ResponseEntity<RevendaResponsetDTO> createRevenda(@RequestBody @Valid RevendaRequestDTO revendaRequestDTO) {
        RevendaResponsetDTO createdRevenda = revendaService.createRevenda(revendaRequestDTO);
        return ResponseEntity.ok(createdRevenda);
    }
}
