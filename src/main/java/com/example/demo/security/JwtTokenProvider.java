package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public String getEmailFromJwt(String token) {
        return token; // portal-safe dummy
    }

    public String generateToken(String email) {
        return email + "_token";
    }
}
