package com.beverage_app.beverage_distributor_api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CadastroRevendaDTO {

    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String email;
    private List<String> telefones;
    private List<String> nomesContatos;
    private List<String> enderecosEntrega;
}
