package com.example.api_donation.service;

import com.example.api_donation.dto.ShelterDTO;
import com.example.api_donation.exception.ResourceNotFoundException;
import com.example.api_donation.mapper.ShelterMapper;
import com.example.api_donation.model.ShelterModel;
import com.example.api_donation.repository.ShelterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShelterService {

    private final ShelterRepository repository;
    private final ShelterMapper mapper;

    public ShelterService(ShelterRepository repository, ShelterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ShelterDTO> listAll(String nome) {
        List<ShelterModel> shelters = (nome == null)
                ? repository.findAll()
                : repository.findByNomeContaining(nome);

        return shelters.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ShelterDTO searchById(Long id) {
        ShelterModel shelter = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Abrigo não encontrado."));
        return mapper.toDTO(shelter);
    }

    public ShelterDTO save(ShelterDTO dto) {
        ShelterModel shelter = mapper.toEntity(dto);
        if (shelter.getOcupacaoAtual() > shelter.getCapacidade()) {
            throw new IllegalArgumentException("A ocupação atual não pode exceder a capacidade.");
        }
        return mapper.toDTO(repository.save(shelter));
    }

    public ShelterDTO update(Long id, ShelterDTO dto) {
        ShelterModel existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Abrigo não encontrado."));

        if (dto.getNome() != null) {
            existente.setNome(dto.getNome());
        }
        if (dto.getEndereco() != null) {
            existente.setEndereco(dto.getEndereco());
        }
        if (dto.getCapacidade() != null) {
            if (dto.getCapacidade() < 0) {
                throw new IllegalArgumentException("Capacidade não pode ser negativa.");
            }
            existente.setCapacidade(dto.getCapacidade());
        }
        if (dto.getTelefone() != null) {
            existente.setTelefone(dto.getTelefone());
        }

        return mapper.toDTO(repository.save(existente));
    }


    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Abrigo não encontrado.");
        }
        repository.deleteById(id);
    }
}
