package com.veterinarynux.veterinary_api.controller;

import com.veterinarynux.veterinary_api.model.Appointment;
import com.veterinarynux.veterinary_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.veterinarynux.veterinary_api.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/appointments")
@Controller
public class AppointmentController {

  private final AppointmentService appointmentService;

  @Autowired
  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @GetMapping
  public String createAppointment() {
    return "pages/createAppointment";
  }

  @PostMapping
  public String createAppointment(@RequestBody Appointment appointment) {
    appointmentService.createAppointment(appointment);
    return "pages/createAppointment";
  }

}
