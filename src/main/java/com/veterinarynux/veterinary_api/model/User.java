package com.veterinarynux.veterinary_api.model;

import java.util.Set;

import com.veterinarynux.veterinary_api.model.base.Auditable;
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

  @Column(unique = true)
  private String email;

  @Column(unique = true)
  private String username;
  private String password;
  private String phone;
  private String address;
  @Builder.Default
  private boolean active = true;

  @Singular
  @ManyToMany(fetch = FetchType.EAGER, cascade = {
      CascadeType.DETACH,
      CascadeType.MERGE,
      CascadeType.PERSIST,
      CascadeType.REFRESH
  })
  private Set<Role> roles;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private ClientDetails clienteDetails;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private VeterinarianDetails veterinarianDetails;

  public User(String name, String email, String password, String username,
      Set<Role> roles) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.username = username;
    this.roles = roles;
  }
}
