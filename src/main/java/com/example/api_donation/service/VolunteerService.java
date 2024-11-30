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

        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setTelefone(dto.getTelefone());
        existente.setHabilidade(dto.getHabilidade());
        existente.setDisponibilidade(dto.getDisponibilidade());

        return mapper.toDTO(repository.save(existente));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Voluntário não encontrado.");
        }
        repository.deleteById(id);
    }
}