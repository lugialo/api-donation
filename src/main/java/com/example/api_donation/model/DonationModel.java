package com.example.api_donation.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Entity
@Table(name = "donation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class DonationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private int quantidade;
    private String dataValidade; // opcional

}
