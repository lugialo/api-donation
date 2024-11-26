package com.example.api_donation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shelter {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String localizacao;
    private Int capacidade;
    private String contato;

    public Long getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao
    }

    public Int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Int capacidade) {
        this.capacidade = capacidade;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}