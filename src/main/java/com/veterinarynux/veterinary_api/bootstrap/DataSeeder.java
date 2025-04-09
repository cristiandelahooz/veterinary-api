package com.veterinarynux.veterinary_api.bootstrap;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.veterinarynux.veterinary_api.service.UserService;
import com.veterinarynux.veterinary_api.model.ClientDetails;
import com.veterinarynux.veterinary_api.model.Role;
import com.veterinarynux.veterinary_api.model.User;
import com.veterinarynux.veterinary_api.model.enums.*;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
  private final UserService userService;

  @Override
  public void run(String... args) throws Exception {
    User client = User.builder()
        .name("Cristian")
        .email("admin@example.com")
        .username("admin")
        .password("admin")
        .phone("123456789")
        .roles(Set.of(Role.builder()
            .name(RoleEnum.CLIENT)
            .build()))
        .address("123 Main St")
        .build();

    ClientDetails details = ClientDetails.builder()
        .user(client)
        .build();

    client.setClienteDetails(details);
    userService.registerUser(client);
  }

}
