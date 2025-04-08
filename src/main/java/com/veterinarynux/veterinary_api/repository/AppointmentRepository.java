package com.veterinarynux.veterinary_api.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinarynux.veterinary_api.model.Appointment;
import com.veterinarynux.veterinary_api.model.enums.AppointmentStatus;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

  List<Appointment> findByDateBetween(LocalDate startDate, LocalDate endDate);

  List<Appointment> findByStatus(AppointmentStatus status);
}
