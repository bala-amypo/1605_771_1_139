package com.example.demo.security;

import java.util.Base64;
import java.util.Set;

public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        String raw = userId + ":" + email;
        return Base64.getEncoder().encodeToString(raw.getBytes());
    }

    public boolean validateToken(String token) {
        try {
            Base64.getDecoder().decode(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split(":")[1];
    }
}
