package com.beverage_app.beverage_distributor_api.services;

import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaResponsetDTO;
import com.beverage_app.beverage_distributor_api.mappers.RevendaMapper;
import com.beverage_app.beverage_distributor_api.models.Revenda;
import com.beverage_app.beverage_distributor_api.repositories.RevendaRepository;
import org.springframework.stereotype.Service;

@Service
public class RevendaService {

    private final RevendaRepository revendaRepository;
    private final RevendaMapper revendaMapper;

    public RevendaService(RevendaRepository revendaRepository,
                          RevendaMapper revendaMapper) {
        this.revendaRepository = revendaRepository;
        this.revendaMapper = revendaMapper;
    }

    public RevendaResponsetDTO createRevenda(RevendaRequestDTO revendaRequestDTO) {
        Revenda revenda = this.revendaMapper.toRevenda(revendaRequestDTO);
        Revenda savedRevenda = this.revendaRepository.save(revenda);
        return this.revendaMapper.toRevendaResponseDTO(savedRevenda);
    }
}
