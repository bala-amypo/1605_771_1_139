package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationFilter {

    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
}
