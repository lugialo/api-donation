package com.example.api_donation.dto;
import lombok.Data;

@Data
public class DonationDTO {
    private Long id;
    private String nome;
    private String categoria;
    private int quantidade;
    private String dataValidade;
}
