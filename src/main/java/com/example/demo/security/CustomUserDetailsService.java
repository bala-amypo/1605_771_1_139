package com.example.demo.security;

import java.util.Set;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

public class CustomUserDetailsService {

    private UserRepository userRepository;

    // Used by testcases via reflection
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CustomUserDetails loadUserByUsername(String email) {

        User user = userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new CustomUserDetails(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                Set.of(Role.USER)
        );
    }
}
