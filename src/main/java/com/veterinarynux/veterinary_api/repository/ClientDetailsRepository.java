package com.veterinarynux.veterinary_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinarynux.veterinary_api.model.ClientDetails;

public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Long> {
}
