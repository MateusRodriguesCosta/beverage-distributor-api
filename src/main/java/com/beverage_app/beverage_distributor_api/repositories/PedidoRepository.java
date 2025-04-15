package com.beverage_app.beverage_distributor_api.repositories;

import com.beverage_app.beverage_distributor_api.models.PedidoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoCliente, Long> {
}
