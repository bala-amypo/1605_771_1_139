package com.example.demo.security;

import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class JwtTokenProvider {
    
    public String createToken(Long userId, String email, Set<String> roles) {
        // Simple token generation (enhance this for production)
        return "jwt-token-" + userId + "-" + email;
    }
    
    public String getEmail(String token) {
        // Extract email from token
        String[] parts = token.split("-");
        return parts.length > 3 ? parts[3] : null;
    }
    
    public String getUserId(String token) {
        // Extract user ID from token
        String[] parts = token.split("-");
        return parts.length > 2 ? parts[2] : null;
    }
}