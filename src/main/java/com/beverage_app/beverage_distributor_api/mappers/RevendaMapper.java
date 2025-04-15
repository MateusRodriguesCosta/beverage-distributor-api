package com.beverage_app.beverage_distributor_api.mappers;

import com.beverage_app.beverage_distributor_api.dtos.RevendaDTO;
import com.beverage_app.beverage_distributor_api.models.Revenda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RevendaMapper {
    RevendaDTO toCadastroRevendaDTO(Revenda revenda);
    Revenda toRevenda(RevendaDTO cadastroRevenda);
}
