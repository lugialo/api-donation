package com.example.api_volunteer.mapper;

import com.example.api_volunteer.dto.VolunteerDTO;
import com.example.api_volunteer.model.VolunteerModel;
import org.springframework.stereotype.Component;

@Component
public class VolunteerMapper {

    public VolunteerDTO toDTO(VolunteerModel model) {
        VolunteerDTO dto = new VolunteerDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setTelefone(model.getTelefone());
        dto.setHabilidade(model.getHabilidade());
        dto.setDisponibilidade(model.getDisponibilidade());
        return dto;
    }

    public VolunteerModel toEntity(VolunteerDTO dto) {
        VolunteerModel model = new VolunteerModel();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setTelefone(dto.getTelefone());
        model.setHabilidade(dto.getHabilidade());
        model.setDisponibilidade(dto.getDisponibilidade());
        return model;
    }
}
