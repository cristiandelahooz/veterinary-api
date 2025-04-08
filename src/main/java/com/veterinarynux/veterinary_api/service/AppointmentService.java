package com.veterinarynux.veterinary_api.service;

import com.veterinarynux.veterinary_api.model.Appointment;
import com.veterinarynux.veterinary_api.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

  @Autowired
  private AppointmentRepository appointmentRepository;

  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  public Optional<Appointment> getAppointmentById(Long id) {
    return appointmentRepository.findById(id);
  }

  public Appointment createAppointment(Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  public void deleteAppointment(Long id) {
    appointmentRepository.deleteById(id);
  }
}
