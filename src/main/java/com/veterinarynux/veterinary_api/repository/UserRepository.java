package com.veterinarynux.veterinary_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinarynux.veterinary_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);

  User findByUsername(String username);

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);
}
