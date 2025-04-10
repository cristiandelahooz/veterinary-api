package com.veterinarynux.veterinary_api.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.veterinarynux.veterinary_api.model.Appointment;

@Component("calendarUtils") // <- este nombre es el que usarás en Thymeleaf
public class CalendarUtils {

  public boolean haveAppointment(List<Appointment> appointments, String hour, String day) {
    if (appointments == null || appointments.isEmpty() || hour == null || day == null) {
      return false;
    }
    return appointments.stream().anyMatch(a -> a.isDay(day) && a.between(hour));
  }
}
