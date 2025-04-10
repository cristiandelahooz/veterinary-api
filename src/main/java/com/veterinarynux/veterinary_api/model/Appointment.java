package com.veterinarynux.veterinary_api.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.veterinarynux.veterinary_api.model.enums.AppointmentStatus;
import com.veterinarynux.veterinary_api.model.enums.AppointmentType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "appointments")
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "description", nullable = false)
  private String description;
  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private ClientDetails clientDetails;

  @ManyToOne
  @JoinColumn(name = "veterinarian_id", nullable = false)
  private VeterinarianDetails veterinarianDetails;

  @Column(name = "appointment_start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "appointment_end_date", nullable = false)
  private LocalDateTime endDate;

  @Enumerated(EnumType.STRING)
  private AppointmentStatus status;

  @Enumerated(EnumType.STRING)
  private AppointmentType type;

  public boolean between(String hour) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    LocalTime targetTime = LocalTime.parse(hour, formatter);
    LocalTime startTime = startDate.toLocalTime();
    LocalTime endTime = endDate.toLocalTime();
    return (targetTime.isAfter(startTime) || targetTime.equals(startTime)) &&
        (targetTime.isBefore(endTime) || targetTime.equals(endTime));
  }

  public String range() {
    return formatHour(startDate.toLocalTime().getHour()) + " - " + formatHour(endDate.toLocalTime().getHour());
  }

  public boolean isDay(String day) {
    return startDate.format(DateTimeFormatter.ofPattern("MMM d")).equals(day);
  }

  private String formatHour(int hour) {
    String period = hour < 12 ? "AM" : "PM";
    int formattedHour = hour % 12 == 0 ? 12 : hour % 12;
    return formattedHour + ":00 " + period;
  }
}
