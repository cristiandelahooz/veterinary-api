package com.veterinarynux.veterinary_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.veterinarynux.veterinary_api.service.AppointmentService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

  private final AppointmentService appointmentService;

}
