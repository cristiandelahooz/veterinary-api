package com.veterinarynux.veterinary_api.model.dto;

import java.util.Set;

import com.veterinarynux.veterinary_api.model.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

  @NotBlank(message = "ID cannot be blank")
  private Long id;

  @NotBlank(message = "Name cannot be blank")
  private String name;

  @Email(message = "Invalid email format")
  @NotBlank(message = "Email cannot be blank")
  private String email;

  @NotBlank(message = "Username cannot be blank")
  private String username;

  @NotBlank(message = "Password cannot be blank")
  @Size(min = 6, message = "Password must be at least 6 characters long")
  private String password;

  @NotBlank(message = "Role cannot be blank")
  private Set<Role> roles;

  @NotBlank(message = "Phone number cannot be blank")
  private String phone;

  @NotBlank(message = "Address cannot be blank")
  private String address;

  public UserDto() {
  }

}
