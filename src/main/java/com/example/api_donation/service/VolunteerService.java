package com.example.api_donation.service;

import com.example.api_donation.dto.DonationDTO;
import com.example.api_donation.dto.VolunteerDTO;
import com.example.api_donation.exception.ResourceNotFoundException;
import com.example.api_donation.mapper.DonationMapper;
import com.example.api_donation.mapper.VolunteerMapper;
import com.example.api_donation.model.DonationModel;
import com.example.api_donation.model.VolunteerModel;
import com.example.api_donation.repository.DonationRepository;
import com.example.api_donation.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerService {

    private final VolunteerRepository repository;
    private final VolunteerMapper mapper;

    public VolunteerService(VolunteerRepository repository, VolunteerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<VolunteerDTO> listAll(String habilidade) {
        List<VolunteerModel> voluntarios = (habilidade == null)
                ? repository.findAll()
                : repository.findByHabilidade(habilidade);

        return voluntarios.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public VolunteerDTO searchById(Long id) {
        VolunteerModel voluntario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado."));
        return mapper.toDTO(voluntario);
    }

    public VolunteerDTO save(VolunteerDTO dto) {
        VolunteerModel voluntario = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(voluntario));
    }

    public VolunteerDTO update(Long id, VolunteerDTO dto) {
        VolunteerModel existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voluntário não encontrado."));

        if (dto.getNome() != null) {
            existente.setNome(dto.getNome());
        }
        if (dto.getEmail() != null) {
            existente.setEmail(dto.getEmail());
        }
        if (dto.getTelefone() != null) {
            existente.setTelefone(dto.getTelefone());
        }
        if (dto.getHabilidade() != null) {
            existente.setHabilidade(dto.getHabilidade());
        }
        if (dto.getDisponibilidade() != null) {
            existente.setDisponibilidade(dto.getDisponibilidade());
        }
        return mapper.toDTO(repository.save(existente));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Voluntário não encontrado.");
        }
        repository.deleteById(id);
    }
}