package com.beverage_app.beverage_distributor_api.services;

import com.beverage_app.beverage_distributor_api.dtos.CadastroRevendaDTO;
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

    public CadastroRevendaDTO createRevenda(CadastroRevendaDTO cadastroRevendaDTO) {
        Revenda revenda = this.revendaMapper.toRevenda(cadastroRevendaDTO);
        Revenda savedRevenda = this.revendaRepository.save(revenda);
        return this.revendaMapper.toCadastroRevendaDTO(savedRevenda);
    }
}
