package com.example.demo.entity; // This was likely missing or wrong

import jakarta.persistence.*; // Use javax.persistence.* if using Spring Boot 2
import java.util.Set;

@Entity
@Table(name = "users") // Good practice to avoid conflict with SQL keywords
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    
    // Assuming you might have roles or email based on standard auth
    private String email; 

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}