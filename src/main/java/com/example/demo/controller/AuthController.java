package com.example.demo.controller;

import com.example.demo.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return "JWT_TOKEN";
    }
}
