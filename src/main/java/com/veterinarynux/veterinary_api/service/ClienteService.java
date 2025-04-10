package com.veterinarynux.veterinary_api.service;

import com.veterinarynux.veterinary_api.model.ClientDetails;
import com.veterinarynux.veterinary_api.model.User;
import com.veterinarynux.veterinary_api.repository.ClientDetailsRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClientDetailsRepository clientDetailsRepository;

    public void save(@NotNull ClientDetails clientDetails) {
        clientDetailsRepository.save(clientDetails);
    }
    public ClientDetails findClientByUser(Optional<User> user) {
        return clientDetailsRepository.findByUser(user);
    }

}
