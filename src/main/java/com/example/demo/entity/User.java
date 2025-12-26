package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String role; // e.g., "ROLE_ADMIN"
    private boolean active = true;

    // Explicitly defining these to ensure the compiler finds them
    public String getRole() { return role; }
    public boolean isActive() { return active; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}