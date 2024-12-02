package com.example.api_donation.repository;

import com.example.api_donation.model.ShelterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShelterRepository extends JpaRepository<ShelterModel, Long> {
    List<ShelterModel> findByNomeContaining(String nome);
}
