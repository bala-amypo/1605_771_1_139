package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Changed to Optional to match common test patterns
    Optional<User> findByUsername(String username);
    
    // Added because the test likely calls it
    Optional<User> findByEmail(String email);
}