package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class JwtTokenProvider {
    private final String SECRET = "YourSecretKeyForJWTTokenGenerationMustBeLongEnough";
    private final long EXPIRATION = 86400000; 

    public String createToken(Long userId, String email, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("userId", userId);
        claims.put("roles", roles);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) { return false; }
    }

    public String getEmail(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
    }
}