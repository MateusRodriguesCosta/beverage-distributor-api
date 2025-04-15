package com.beverage_app.beverage_distributor_api.repositories;

import com.beverage_app.beverage_distributor_api.models.Revenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RevendaRepository  extends JpaRepository<Revenda, Long> {
    Optional<Revenda> findByCnpj(String cnpj);
}
