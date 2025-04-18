package com.veterinarynux.veterinary_api.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.veterinarynux.veterinary_api.model.Appointment;
import com.veterinarynux.veterinary_api.service.AppointmentService;
import com.veterinarynux.veterinary_api.util.CalendarUtils;

import lombok.RequiredArgsConstructor;

@RequestMapping("/calendar")
@Controller
@RequiredArgsConstructor
public class CalendarController {

  private final AppointmentService appointmentService;

  @GetMapping
  public String showCalendar(Model model) {
    LocalDate now = LocalDate.now();
    int month = now.getMonthValue();
    int year = now.getYear();

    String currentDate = now.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

    List<String> weekDays = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
        .datesUntil(now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY)).plusDays(1))
        .map(date -> date.format(DateTimeFormatter.ofPattern("MMM d")))
        .collect(Collectors.toList());

    String today = now.format(DateTimeFormatter.ofPattern("MMM d"));

    List<String> hours = IntStream.range(7, 20)
        .mapToObj(hour -> LocalTime.of(hour, 0).format(DateTimeFormatter.ofPattern("hh:mm a")))
        .collect(Collectors.toList());

    List<Appointment> appointments = appointmentService.getAllAppointments();
    Map<String, List<Appointment>> appointmentsByDay = appointments.stream()
        .filter(appointment -> {
          LocalDate startOfWeek = LocalDate.now().with(DayOfWeek.MONDAY);
          LocalDate endOfWeek = startOfWeek.plusDays(6);
          LocalDate appointmentDate = appointment.getStartDate().toLocalDate();
          return !appointmentDate.isBefore(startOfWeek) && !appointmentDate.isAfter(endOfWeek);
        })
        .collect(Collectors
            .groupingBy(appointment -> appointment.getStartDate().format(DateTimeFormatter.ofPattern("MMM d"))));

    Map<String, Object> modelMap = new HashMap<>() {
      {
        put("appointmentsByDay", appointmentsByDay);
        put("year", year);
        put("month", month);
        put("today", today);
        put("daysInMonth", now.lengthOfMonth());
        put("currentDate", currentDate);
        put("weekDays", weekDays);
        put("hours", hours);
        put("calendarUtils", new CalendarUtils());
      }
    };
    model.addAllAttributes(modelMap);
    return "pages/calendar";
  }
}
