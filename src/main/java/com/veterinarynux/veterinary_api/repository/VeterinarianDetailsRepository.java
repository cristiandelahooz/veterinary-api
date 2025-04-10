package com.veterinarynux.veterinary_api.repository;

import com.veterinarynux.veterinary_api.model.ClientDetails;
import com.veterinarynux.veterinary_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinarynux.veterinary_api.model.VeterinarianDetails;

import java.util.Optional;

public interface VeterinarianDetailsRepository extends JpaRepository<VeterinarianDetails, Long> {
    VeterinarianDetails findByUser(Optional<User> user);
}
