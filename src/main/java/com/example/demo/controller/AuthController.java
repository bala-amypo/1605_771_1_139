package com.example.demo.controller;

import com.example.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public String login(@RequestParam String email) {
        return tokenProvider.generateToken(email);
    }
}
