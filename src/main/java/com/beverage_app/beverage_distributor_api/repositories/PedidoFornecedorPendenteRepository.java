package com.beverage_app.beverage_distributor_api.repositories;

import com.beverage_app.beverage_distributor_api.models.PedidoFornecedorPendente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoFornecedorPendenteRepository extends JpaRepository<PedidoFornecedorPendente, Long> {
}
