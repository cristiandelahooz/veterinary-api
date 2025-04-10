package com.veterinarynux.veterinary_api.service;

import com.veterinarynux.veterinary_api.model.User;
import org.springframework.stereotype.Service;

import com.veterinarynux.veterinary_api.model.VeterinarianDetails;
import com.veterinarynux.veterinary_api.repository.VeterinarianDetailsRepository;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeterinarianService {
  private final VeterinarianDetailsRepository veterinarianDetailsRepository;

  public void save(@NotNull VeterinarianDetails veterinarianDetails) {
    veterinarianDetailsRepository.save(veterinarianDetails);
  }

  public VeterinarianDetails findClientByUser(Optional<User> user) {
    return veterinarianDetailsRepository.findByUser(user);
  }
}
