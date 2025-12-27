package com.example.demo.entity;

import jakarta.persistence.*; // Use javax.persistence.* if on Spring Boot 2
import java.util.Set;

@Entity
@Table(name = "users") 
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email; 
    private String roles; // <--- ADDED THIS FIELD

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRoles() { return roles; }      // <--- ADDED GETTER
    public void setRoles(String roles) { this.roles = roles; } // <--- ADDED SETTER
}