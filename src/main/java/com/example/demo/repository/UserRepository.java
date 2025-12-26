package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // REQUIRED for FullProjectTest
    Optional<User> findByEmail(String email);

    // OPTIONAL (used in security)
    Optional<User> findByEmailIgnoreCase(String email);
}
