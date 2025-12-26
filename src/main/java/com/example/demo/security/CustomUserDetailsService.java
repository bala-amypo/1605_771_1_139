package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {

    private UserRepository userRepository;

    // setter used by TestNG / reflection
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loadUserByUsername(String email) {
        return userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
