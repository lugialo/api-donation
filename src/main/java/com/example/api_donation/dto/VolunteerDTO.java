package com.example.api_volunteer.dto;

import lombok.Data;

@Data
public class VolunteerDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String habilidade;
    private String disponibilidade;
}
