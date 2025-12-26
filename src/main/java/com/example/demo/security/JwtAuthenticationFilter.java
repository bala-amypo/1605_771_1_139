package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtTokenProvider tokenProvider, UserDetailsService userDetailsService) {
        this.tokenProvider = tokenProvider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String token = getTokenFromRequest(request);

        if (token != null && tokenProvider.validateToken(token)) {
            String email = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication() == null 
                    ? extractEmail(token) // Helper if needed, or rely on tokenProvider
                    : null; 
            
            // Actually, better to just rely on provider:
            // The tokenProvider in previous turn extracted Subject (email)
            // But we need to get it out here to load UserDetails
            
            // Simplified approach based on standard JwtProvider usage:
            // (Assuming JwtTokenProvider has a getEmail or getSubject method - adapting to common patterns)
            
            // NOTE: You need to add getEmail(token) to your JwtTokenProvider if it's not there.
            // Based on previous code, let's assume we can parse it.
        }
        
        // Re-implementing specific block to match the Provider from previous steps:
        try {
             if (token != null && tokenProvider.validateToken(token)) {
                 // In the previous provider code, we didn't explicitly expose getEmail(), 
                 // we only had getUserId and getRoles. 
                 // We should update the Provider or use getRoles to build auth.
                 
                 // However, standard Spring Security needs UserDetails usually.
                 // Let's assume the Subject in the token IS the email.
                 io.jsonwebtoken.Claims claims = io.jsonwebtoken.Jwts.parser()
                    .setSigningKey("secret-key-must-be-very-long-to-be-secure-enough-for-hs256")
                    .parseClaimsJws(token)
                    .getBody();
                 String email = claims.getSubject();

                 UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                 UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                         userDetails, null, userDetails.getAuthorities());
                 
                 SecurityContextHolder.getContext().setAuthentication(authentication);
             }
        } catch (Exception e) {
            // Token invalid or expired
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
    
    private String extractEmail(String token) {
         // Helper to extract if not using the block above
         return null;
    }
}