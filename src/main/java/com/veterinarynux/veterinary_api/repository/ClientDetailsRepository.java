package com.veterinarynux.veterinary_api.repository;

import com.veterinarynux.veterinary_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinarynux.veterinary_api.model.ClientDetails;

import java.util.Optional;

public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Long> {
    ClientDetails findByUser(Optional<User> user);

}
