package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ Get logged-in user profile (using JWT token)
    @GetMapping("/me")
    public User getMyProfile(Principal principal) {
        // principal.getName() → email (from JWT)
        return userService.findByEmail(principal.getName());
    }
}
