package com.veterinarynux.veterinary_api.model.dto;

import com.veterinarynux.veterinary_api.model.User;

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

  @NotBlank(message = "Password cannot be blank")
  @Size(min = 6, message = "Password must be at least 6 characters long")
  private String password;

  @NotBlank(message = "Phone number cannot be blank")
  private String phoneNumber;

  @NotBlank(message = "Address cannot be blank")
  private String address;

  public UserDto() {
  }

  public User toUser() {
    User user = User.builder()
        .name(name)
        .email(email)
        .password(password)
        .phoneNumber(phoneNumber)
        .address(address)
        .build();
    return user;
  }

}
