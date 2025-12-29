package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "universities")
public class University {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String code;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @OneToMany(mappedBy = "sourceUniversity", cascade = CascadeType.ALL)
    private Set<TransferRule> sourceRules = new HashSet<>();
    
    @OneToMany(mappedBy = "targetUniversity", cascade = CascadeType.ALL)
    private Set<TransferRule> targetRules = new HashSet<>();
    
    // Default constructor
    public University() {
    }
    
    // Constructor with id
    public University(Long id) {
        this.id = id;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    // Method required by tests
    public Boolean isActive() {
        return this.isActive;
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