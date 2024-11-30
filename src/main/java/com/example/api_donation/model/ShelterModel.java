package com.example.api_shelter.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShelterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String telefone;
    private Integer capacidade;
    private Integer ocupacaoAtual;
}