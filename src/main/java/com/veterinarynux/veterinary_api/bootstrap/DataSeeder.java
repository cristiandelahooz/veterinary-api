package com.veterinarynux.veterinary_api.bootstrap;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.veterinarynux.veterinary_api.service.AppointmentService;
import com.veterinarynux.veterinary_api.service.UserService;
import com.veterinarynux.veterinary_api.model.Appointment;
import com.veterinarynux.veterinary_api.model.ClientDetails;
import com.veterinarynux.veterinary_api.model.Role;
import com.veterinarynux.veterinary_api.model.User;
import com.veterinarynux.veterinary_api.model.VeterinarianDetails;
import com.veterinarynux.veterinary_api.model.enums.*;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
  private final UserService userService;
  private final AppointmentService appointmentService;

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

    User veterinarian = User.builder()
        .name("Dr. Smith")
        .email("smith@gmail.com")
        .username("drsmith")
        .password("password")
        .phone("987654321")
        .roles(Set.of(Role.builder()
            .name(RoleEnum.VETERINARIAN)
            .build()))
        .address("456 Elm St")
        .build();

    ClientDetails details = ClientDetails.builder()
        .user(client)
        .build();

    VeterinarianDetails veterinarianDetails = VeterinarianDetails.builder()
        .user(veterinarian)
        .specialty(Specialty.EMERGENCY_AND_CRITICAL_CARE)
        .build();

    client.setClienteDetails(details);
    veterinarian.setVeterinarianDetails(veterinarianDetails);
    userService.registerUser(client);
    userService.registerUser(veterinarian);

    Appointment appointment = Appointment.builder()
        .description("Annual check-up")
        .startDate(LocalDateTime.now().withHour(11).withMinute(0).withSecond(0).withNano(0))
        .endDate(LocalDateTime.now().withHour(13).withMinute(0).withSecond(0).withNano(0))
        .status(AppointmentStatus.SCHEDULED)
        .type(AppointmentType.CHECKUP)
        .clientDetails(details)
        .veterinarianDetails(veterinarianDetails)
        .build();

    appointmentService.createAppointment(appointment);
  }
}
