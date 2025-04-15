package com.beverage_app.beverage_distributor_api.mappers;

import com.beverage_app.beverage_distributor_api.dtos.CadastroRevendaDTO;
import com.beverage_app.beverage_distributor_api.models.Revenda;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RevendaMapper {
    CadastroRevendaDTO toCadastroRevendaDTO(Revenda revenda);
    Revenda toRevenda(CadastroRevendaDTO cadastroRevenda);
}
