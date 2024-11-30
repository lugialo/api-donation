package com.example.api_volunteer.repository;

import com.example.api_volunteer.model.VolunteerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VolunteerRepository extends JpaRepository<VolunteerModel, Long> {
    List<VolunteerModel> findByHabilidade(String habilidade);
}