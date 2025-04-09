package com.veterinarynux.veterinary_api.model;

import java.time.LocalDateTime;

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

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private ClientDetails clientDetails;

  @ManyToOne
  @JoinColumn(name = "veterinarian_id", nullable = false)
  private VeterinarianDetails veterinarianDetails;

  @Column(name = "appointment_date", nullable = false)
  private LocalDateTime date;

  @Enumerated(EnumType.STRING)
  private AppointmentStatus status;

  @Enumerated(EnumType.STRING)
  private AppointmentType type;
}
