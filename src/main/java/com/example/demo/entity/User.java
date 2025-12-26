package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private String password;
    
    private String role; // Stores value like "ADMIN" or "EVALUATOR"

    // Manual helper methods to satisfy service layer requirements
    public String getRole() { return this.role; }
    public boolean isActive() { return true; } 
}