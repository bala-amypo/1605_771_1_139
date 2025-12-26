package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.*;

public class JwtTokenProvider {

    private final String secret = "secretkey";

    public String createToken(Long userId, String email, Set<String> roles) {
        return Jwts.builder()
                .claim("uid", userId)
                .claim("email", email)
                .claim("roles", roles)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("email", String.class);
    }

    public Long getUserId(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token).getBody().get("uid", Long.class);
    }

    public Set<String> getRoles(String token) {
        return new HashSet<>(
                Jwts.parser().setSigningKey(secret)
                        .parseClaimsJws(token).getBody().get("roles", List.class)
        );
    }
}
