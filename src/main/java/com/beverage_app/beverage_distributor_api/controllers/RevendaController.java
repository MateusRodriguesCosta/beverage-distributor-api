package com.beverage_app.beverage_distributor_api.controllers;

import com.beverage_app.beverage_distributor_api.dtos.RevendaDTO;
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
    public ResponseEntity<RevendaDTO> createRevenda(@RequestBody @Valid RevendaDTO revendaDTO) {
        RevendaDTO createdRevenda = revendaService.createRevenda(revendaDTO);
        return ResponseEntity.ok(createdRevenda);
    }
}
