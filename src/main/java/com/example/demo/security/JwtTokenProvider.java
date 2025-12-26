package com.example.demo.security;

import java.util.*;
import java.util.Base64;

public class JwtTokenProvider {

    public String createToken(Long userId, String email, Set<String> roles) {
        return Base64.getEncoder()
                .encodeToString((userId + ":" + email + ":" + String.join(",", roles)).getBytes());
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
        return new String(Base64.getDecoder().decode(token)).split(":")[1];
    }

    public Long getUserId(String token) {
        return Long.parseLong(new String(Base64.getDecoder().decode(token)).split(":")[0]);
    }

    public Set<String> getRoles(String token) {
        return Set.of(new String(Base64.getDecoder().decode(token)).split(":")[2].split(","));
    }
}
