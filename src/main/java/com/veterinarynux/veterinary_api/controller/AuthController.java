package com.veterinarynux.veterinary_api.controller;

import com.veterinarynux.veterinary_api.model.dto.UserDto;
import com.veterinarynux.veterinary_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

  private final AuthService authService;

  @Autowired
  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @GetMapping("/login")
  public String showLoginPage() {
    return "auth/login"; // Thymeleaf template for login
  }

  @GetMapping("/register")
  public String showRegistrationPage(Model model) {
    model.addAttribute("user", new UserDto());
    return "auth/register"; // Thymeleaf template for registration
  }

  @PostMapping("/register")
  public String registerUser(@Valid @ModelAttribute("user") UserDto userDto,
      BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      return "auth/register"; // Return to registration page if validation fails
    }

    try {
      authService.registerUser(userDto);
    } catch (IllegalArgumentException e) {
      model.addAttribute("error", e.getMessage());
      return "auth/register";
    }

    return "redirect:/login?success"; // Redirect to login page on successful registration
  }

  @GetMapping("/logout")
  public String logout() {
    return "redirect:/login?logout"; // Redirect to login page after logout
  }
}
