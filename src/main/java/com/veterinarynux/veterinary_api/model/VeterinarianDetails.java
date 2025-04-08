package com.veterinarynux.veterinary_api.model;

import com.veterinarynux.veterinary_api.model.base.Auditable;
import com.veterinarynux.veterinary_api.model.enums.Specialty;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarianDetails extends Auditable {
  @Id
  private Long id;
  private Specialty specialty;

  @OneToOne
  @MapsId
  private User user;
}
