package com.veterinarynux.veterinary_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.veterinarynux.veterinary_api.model.Appointment;
import com.veterinarynux.veterinary_api.service.AppointmentService;

@RequestMapping("/appointments")
@Controller
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;

  @GetMapping
  public String getAllAppointments(Model model) {
    List<Appointment> appointments = appointmentService.getAllAppointments();
    model.addAttribute("appointments", appointments);
    return "appointments/list"; // Returns the Thymeleaf view "list.html" under "appointments" folder
  }

  @GetMapping("/new")
  public String showCreateAppointmentForm(Model model) {
    model.addAttribute("appointment", new Appointment());
    return "appointments/create"; // Returns the Thymeleaf view "create.html" under "appointments" folder
  }

  @PostMapping
  public String createAppointment(@ModelAttribute Appointment appointment) {
    appointmentService.createAppointment(appointment);
    return "redirect:/appointments"; // Redirects to the list of appointments
  }
}
