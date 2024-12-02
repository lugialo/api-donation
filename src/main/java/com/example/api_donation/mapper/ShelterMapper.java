package com.example.api_donation.mapper;

import com.example.api_donation.dto.ShelterDTO;
import com.example.api_donation.model.ShelterModel;
import org.springframework.stereotype.Component;

@Component
public class ShelterMapper {

    public ShelterDTO toDTO(ShelterModel model) {
        ShelterDTO dto = new ShelterDTO();
        dto.setId(model.getId());
        dto.setNome(model.getNome());
        dto.setEndereco(model.getEndereco());
        dto.setTelefone(model.getTelefone());
        dto.setCapacidade(model.getCapacidade());
        dto.setOcupacaoAtual(model.getOcupacaoAtual());
        return dto;
    }

    public ShelterModel toEntity(ShelterDTO dto) {
        ShelterModel model = new ShelterModel();
        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setEndereco(dto.getEndereco());
        model.setTelefone(dto.getTelefone());
        model.setCapacidade(dto.getCapacidade());
        model.setOcupacaoAtual(dto.getOcupacaoAtual());
        return model;
    }
}