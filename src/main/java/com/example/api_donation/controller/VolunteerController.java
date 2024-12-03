package com.example.api_donation.controller;

import com.example.api_donation.dto.VolunteerDTO;
import com.example.api_donation.service.VolunteerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VolunteerDTO>> listAll(@RequestParam(value = "habilidade", required = false) String habilidade) {
        List<VolunteerDTO> volunteers = service.listAll(habilidade);
        return ResponseEntity.ok(volunteers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerDTO> searchById(@PathVariable Long id) {
        VolunteerDTO volunteer = service.searchById(id);
        return ResponseEntity.ok(volunteer);
    }

    @PostMapping
    public ResponseEntity<VolunteerDTO> save(@Valid @RequestBody VolunteerDTO dto) {
        VolunteerDTO savedVolunteer = service.save(dto);
        return ResponseEntity.ok(savedVolunteer);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<VolunteerDTO> update(@PathVariable Long id, @Valid @RequestBody VolunteerDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
