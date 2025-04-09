package com.veterinarynux.veterinary_api.model;

import jakarta.persistence.*;
import lombok.*;
import com.veterinarynux.veterinary_api.model.enums.RoleEnum;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private RoleEnum name;

  public Role(String name) {
    this.name = RoleEnum.valueOf(name);
  }
}
