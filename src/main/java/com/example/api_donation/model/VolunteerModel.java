package com.example.api_donation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VolunteerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String habilidade;
    private String disponibilidade;
}
