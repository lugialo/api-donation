package com.example.api_donation.repository;

import com.example.api_donation.model.DonationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<DonationModel, Long> {
    List<DonationModel> findByCategoria(String categoria);
}
