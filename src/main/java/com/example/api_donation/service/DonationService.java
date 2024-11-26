package com.example.api_donation.service;

import com.example.api_donation.dto.DonationDTO;
import com.example.api_donation.exception.ResourceNotFoundException;
import com.example.api_donation.mapper.DonationMapper;
import com.example.api_donation.model.DonationModel;
import com.example.api_donation.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationService {

    private final DonationRepository repository;
    private final DonationMapper mapper;

    public DonationService(DonationRepository repository, DonationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DonationDTO> listAll(String categoria) {
        List<DonationModel> donativos = (categoria == null)
                ? repository.findAll()
                : repository.findByCategoria(categoria);

        return donativos.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public DonationDTO searchById(Long id) {
        DonationModel donativo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Donativo não encontrado."));
        return mapper.toDTO(donativo);
    }

    public DonationDTO salvar(DonationDTO dto) {
        DonationModel donativo = mapper.toEntity(dto);
        if (donativo.getQuantidade() < 0) {
            throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        }
        return mapper.toDTO(repository.save(donativo));
    }

    public DonationDTO update(Long id, DonationDTO dto) {
        DonationModel existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Donativo não encontrado."));

        existente.setNome(dto.getNome());
        existente.setCategoria(dto.getCategoria());
        existente.setQuantidade(dto.getQuantidade());
        existente.setDataValidade(dto.getDataValidade());

        return mapper.toDTO(repository.save(existente));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Donativo não encontrado.");
        }
        repository.deleteById(id);
    }
}