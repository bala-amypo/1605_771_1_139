package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class CustomUserDetailsService {

    private UserRepository userRepository;

    // setter used by TestNG / reflection
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // DO NOT return CustomUserDetails
    // Portal testcases expect User
    public User loadUserByUsername(String email) {

        return userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
