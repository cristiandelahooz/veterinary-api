package com.veterinarynux.veterinary_api.model.enums;

public enum AppointmentStatus {
  SCHEDULED, // Appointment is scheduled but not yet completed
  COMPLETED, // Appointment has been completed
  CANCELLED, // Appointment was cancelled by the client or veterinarian
  NO_SHOW, // Client did not show up for the appointment
  RESCHEDULED; // Appointment was rescheduled to a different time
}
