package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    private String password;
    private String roles;
    
    @OneToMany(mappedBy = "sourceUniversity", cascade = CascadeType.ALL)
    private Set<TransferRule> sourceRules = new HashSet<>();
    
    @OneToMany(mappedBy = "targetUniversity", cascade = CascadeType.ALL)
    private Set<TransferRule> targetRules = new HashSet<>();
    
    // Default constructor
    public User() {
    }
    
    // Constructor matching test requirements
    public User(String email, String password, String roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRoles() {
        return roles;
    }
    
    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    // Method required by AuthController
    public String getRole() {
        return this.roles;
    }
    
    public Set<TransferRule> getSourceRules() {
        return sourceRules;
    }
    
    public void setSourceRules(Set<TransferRule> sourceRules) {
        this.sourceRules = sourceRules;
    }
    
    public Set<TransferRule> getTargetRules() {
        return targetRules;
    }
    
    public void setTargetRules(Set<TransferRule> targetRules) {
        this.targetRules = targetRules;
    }
}