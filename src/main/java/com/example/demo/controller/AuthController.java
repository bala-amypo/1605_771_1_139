package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        User dbUser = userService.findByEmail(user.getEmail());

        String token = jwtTokenProvider.generateToken(dbUser.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return response;
    }
}
