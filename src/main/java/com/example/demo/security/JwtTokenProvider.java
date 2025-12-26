package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {
    private final String secretKey = "secret-key-must-be-very-long-to-be-secure-enough-for-hs256";

    public String createToken(Long userId, String email, Set<String> roles) {
        Claims claims = Jwts.claims().setSubject(email);
        claims.put("userId", userId);
        claims.put("roles", roles);

        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1h

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Set<String> getRoles(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        // The cast here assumes the structure stored in createToken
        return (Set<String>) claims.get("roles"); // In real app, proper casting needed
    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        return ((Number) claims.get("userId")).longValue();
    }
}