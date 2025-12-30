package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
            )
        );

        return "LOGIN SUCCESS";
    }
}
