package com.example.api_donation.controller;

import com.example.api_donation.dto.DonationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.api_donation.service.DonationService;

import java.util.List;

@RestController
@RequestMapping("/donation")
public class DonationController {

    private final DonationService service;

    public DonationController(DonationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DonationDTO>> listar(@RequestParam(required = false) String categoria) {
        return ResponseEntity.ok(service.listAll(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationDTO> search(@PathVariable Long id) {
        return ResponseEntity.ok(service.searchById(id));
    }

    @PostMapping
    public ResponseEntity<DonationDTO> create(@RequestBody DonationDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DonationDTO> update(@PathVariable Long id, @RequestBody DonationDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
