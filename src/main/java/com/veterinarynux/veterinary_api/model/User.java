package com.veterinarynux.veterinary_api.model;

import com.veterinarynux.veterinary_api.model.base.Auditable;
import com.veterinarynux.veterinary_api.model.enums.*;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends Auditable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private String username;
  private String password;
  private String phoneNumber;
  private String address;

  @Enumerated(jakarta.persistence.EnumType.STRING)
  private Role rol;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private ClientDetails clienteInfo;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private VeterinarianDetails veterinarioInfo;

  public User(String name, String email, String password, String username,
      Role rol) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.username = username;
    this.rol = rol;
  }
}
