package com.example.api_donation.mapper;

import com.example.api_donation.dto.DonationDTO;
import com.example.api_donation.model.DonationModel;
import org.springframework.stereotype.Component;

@Component
public class DonationMapper {

    public DonationDTO toDTO(DonationModel donation) {
        DonationDTO dto = new DonationDTO();
        dto.setId(donation.getId());
        dto.setNome(donation.getNome());
        dto.setCategoria(donation.getCategoria());
        dto.setQuantidade(donation.getQuantidade());
        dto.setDataValidade(donation.getDataValidade());
        return dto;
    }

    public DonationModel toEntity(DonationDTO dto) {
        return DonationModel.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .categoria(dto.getCategoria())
                .quantidade(dto.getQuantidade())
                .dataValidade(dto.getDataValidade())
                .build();
    }
}
