package com.beverage_app.beverage_distributor_api.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class PedidoFornecedorPendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String payload;

    private LocalDateTime dataCriacao;

    private String status;

}
