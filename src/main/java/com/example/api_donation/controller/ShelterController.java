package com.example.api_donation.controller;

import com.example.api_donation.dto.ShelterDTO;
import com.example.api_donation.service.ShelterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelters")
public class ShelterController {

    private final ShelterService service;

    public ShelterController(ShelterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ShelterDTO>> listAll(@RequestParam(value = "nome", required = false) String nome) {
        List<ShelterDTO> shelters = service.listAll(nome);
        return ResponseEntity.ok(shelters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShelterDTO> searchById(@PathVariable Long id) {
        ShelterDTO shelter = service.searchById(id);
        return ResponseEntity.ok(shelter);
    }

    @PostMapping
    public ResponseEntity<ShelterDTO> save(@Valid @RequestBody ShelterDTO dto) {
        ShelterDTO savedShelter = service.save(dto);
        return ResponseEntity.ok(savedShelter);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ShelterDTO> update(@PathVariable Long id, @Valid @RequestBody ShelterDTO dto) {
        ShelterDTO updatedShelter = service.update(id, dto);
        return ResponseEntity.ok(updatedShelter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
