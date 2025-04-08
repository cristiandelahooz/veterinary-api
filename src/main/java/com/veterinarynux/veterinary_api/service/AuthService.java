package com.veterinarynux.veterinary_api.service;

import com.veterinarynux.veterinary_api.model.User;
import com.veterinarynux.veterinary_api.model.dto.UserDto;
import com.veterinarynux.veterinary_api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public AuthService(AuthenticationManager authenticationManager,
      UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Authentication authenticate(String email, String password) throws AuthenticationException {
    return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(email, password));
  }

  public boolean registerUser(UserDto user) {
    User existingUser = userRepository.findByEmail(user.getEmail());
    if (existingUser == null) {
      return false; // User already exists
    }
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    User newUser = user.toUser();
    userRepository.save(newUser);
    return true;
  }
}
