package com.example.api_shelter.repository;

import com.example.api_shelter.model.ShelterModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelterRepository extends JpaRepository<ShelterModel, Long> {
    List<ShelterModel> findByNomeContaining(String nome);
}
