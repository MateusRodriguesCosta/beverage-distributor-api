package com.beverage_app.beverage_distributor_api.mappers;

import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaRequestDTO;
import com.beverage_app.beverage_distributor_api.dtos.revenda.RevendaResponsetDTO;
import com.beverage_app.beverage_distributor_api.models.Revenda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RevendaMapper {
    RevendaRequestDTO toRevendaRequestDTO(Revenda revenda);
    RevendaResponsetDTO toRevendaResponseDTO(Revenda revenda);
    Revenda toRevenda(RevendaRequestDTO cadastroRevenda);
}
