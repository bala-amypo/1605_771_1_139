package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
    private Long id;   
    private String email; 
    private String password;
    private String role; 
    private LocalDateTime createdAt;
    public User(Long id, String email, String password, String role, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
}
