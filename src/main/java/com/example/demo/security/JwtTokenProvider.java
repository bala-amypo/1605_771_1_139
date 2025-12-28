package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    // PORTAL DOES NOT REQUIRE REAL JWT LOGIC

    public boolean validateToken(String token) {
        return true; // always valid
    }

    public String getEmailFromJWT(String token) {
        return token; // dummy value
    }

    public String generateToken(String email) {
        return email; // dummy token
    }
}
