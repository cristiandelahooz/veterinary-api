package com.veterinarynux.veterinary_api.model;

import com.veterinarynux.veterinary_api.model.base.Auditable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDetails extends Auditable {
  @Id
  private Long id;

  @OneToOne
  @MapsId
  private User user;

}
