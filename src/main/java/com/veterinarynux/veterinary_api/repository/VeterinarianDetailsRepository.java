package com.veterinarynux.veterinary_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinarynux.veterinary_api.model.VeterinarianDetails;

public interface VeterinarianDetailsRepository extends JpaRepository<VeterinarianDetails, Long> {
}
