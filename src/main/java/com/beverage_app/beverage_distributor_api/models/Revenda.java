package com.beverage_app.beverage_distributor_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Revenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "CNPJ inválido")
    @Column(unique = true)
    private String cnpj;

    @NotBlank(message = "Razão Social é obrigatória")
    private String razaoSocial;

    @NotBlank(message = "Nome Fantasia é obrigatório")
    private String nomeFantasia;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @ElementCollection
    private List<String> telefones;

    @ElementCollection
    private List<String> nomesContatos;

    @ElementCollection
    private List<String> enderecosEntrega;

}
