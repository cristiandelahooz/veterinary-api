package com.veterinarynux.veterinary_api.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.veterinarynux.veterinary_api.model.Appointment;
import com.veterinarynux.veterinary_api.model.ClientDetails;
import com.veterinarynux.veterinary_api.model.VeterinarianDetails;
import com.veterinarynux.veterinary_api.model.enums.AppointmentStatus;
import com.veterinarynux.veterinary_api.model.enums.AppointmentType;
import com.veterinarynux.veterinary_api.service.AppointmentService;
import com.veterinarynux.veterinary_api.service.ClienteService;
import com.veterinarynux.veterinary_api.service.UserService;
import com.veterinarynux.veterinary_api.service.VeterinarianService;

@RequestMapping("/appointments")
@Controller
public class AppointmentController {

  private final AppointmentService appointmentService;
  private final UserService userService;
  private final ClienteService clienteService;
  private final VeterinarianService veterinarianService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService, UserService userService,
      ClienteService clienteService, VeterinarianService veterinarianService) {
    this.appointmentService = appointmentService;
    this.userService = userService;
    this.clienteService = clienteService;
    this.veterinarianService = veterinarianService;
  }

  @GetMapping
  public String createAppointment() {
    return "pages/createAppointment";
  }

  @PostMapping
  public String createAppointment(@RequestParam String clientUsername,
      @RequestParam String veterinarianUsername,
      @RequestParam String description,
      @RequestParam("start_time") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime startDate,
      @RequestParam("end_time") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime endDate,
      @RequestParam("appointment_type") String appointmentType) {
    System.out.println("clientUsername: " + clientUsername);
    System.out.println("veterinarianUsername: " + veterinarianUsername);

    ClientDetails client = clienteService.findClientByUser(userService.findUserByUsername(clientUsername));
    VeterinarianDetails vet = veterinarianService
        .findClientByUser(userService.findUserByUsername(veterinarianUsername));

    if (client == null) {
      System.out.println("Client not found for username: " + clientUsername);
      return "error: Cliente no encontrado";
    }

    if (vet == null) {
      System.out.println("Veterinarian not found for username: " + veterinarianUsername);
      return "error: Veterinario no encontrado";
    }

    AppointmentType type = AppointmentType.valueOf(appointmentType);

    Appointment appointment = Appointment.builder()
        .clientDetails(client)
        .veterinarianDetails(vet)
        .description(description)
        .startDate(startDate)
        .endDate(endDate)
        .type(type)
        .status(AppointmentStatus.SCHEDULED)
        .build();

    appointmentService.createAppointment(appointment);
    return "redirect:/calendar";
  }

}
