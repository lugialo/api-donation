package com.example.api_shelter.dto;

import lombok.Data;

@Data
public class ShelterDTO {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private Integer capacidade;
    private Integer ocupacaoAtual;
}
