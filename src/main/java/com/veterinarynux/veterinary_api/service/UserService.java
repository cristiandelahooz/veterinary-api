package com.veterinarynux.veterinary_api.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.veterinarynux.veterinary_api.model.User;
import com.veterinarynux.veterinary_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User registerUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  }

  public Optional<User> findUserById(Long id) {
    return userRepository.findById(id);
  }

  public Optional<User> findUserByEmail(String email) {
    return Optional.ofNullable(userRepository.findByEmail(email));
  }

  public Optional<User> findUserByUsername(String username) {
    return Optional.ofNullable(userRepository.findByUsername(username));
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  public User updateUser(User user) {
    return userRepository.save(user);
  }
}
