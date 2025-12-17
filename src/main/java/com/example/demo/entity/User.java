package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    @Id @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String roles;
    private LocalDateTime createdAt;
    
}
