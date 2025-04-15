package com.beverage_app.beverage_distributor_api.services;

import com.beverage_app.beverage_distributor_api.dtos.RevendaDTO;
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

    public RevendaDTO createRevenda(RevendaDTO revendaDTO) {
        Revenda revenda = this.revendaMapper.toRevenda(revendaDTO);
        Revenda savedRevenda = this.revendaRepository.save(revenda);
        return this.revendaMapper.toCadastroRevendaDTO(savedRevenda);
    }
}
