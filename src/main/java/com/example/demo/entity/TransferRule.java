package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double minimumOverlapPercentage; // fixed missing field
     
    @Column
    private Boolean active = true;

    // Getters and setters
    public Double getMinimumOverlapPercentage() {
        return minimumOverlapPercentage;
    }

    public void setMinimumOverlapPercentage(Double minimumOverlapPercentage) {
        this.minimumOverlapPercentage = minimumOverlapPercentage;
    }
    public Boolean getActive() {
    return active;
    }

     public void setActive(Boolean active) {
    this.active = active;
     }
}
