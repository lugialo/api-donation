package com.example.api_donation.repository;

import com.example.api_donation.model.VolunteerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VolunteerRepository extends JpaRepository<VolunteerModel, Long> {
    List<VolunteerModel> findByHabilidade(String habilidade);
}