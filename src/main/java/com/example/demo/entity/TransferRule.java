package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceUniversity;
    private String targetUniversity;

    private double minimumOverallPercentage;
    private int creditHourTolerance;

    private boolean active;

    // ===== Getters & Setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceUniversity() {
        return sourceUniversity;
    }

    public void setSourceUniversity(String sourceUniversity) {
        this.sourceUniversity = sourceUniversity;
    }

    public String getTargetUniversity() {
        return targetUniversity;
    }

    public void setTargetUniversity(String targetUniversity) {
        this.targetUniversity = targetUniversity;
    }

    public double getMinimumOverallPercentage() {
        return minimumOverallPercentage;
    }

    public void setMinimumOverallPercentage(double minimumOverallPercentage) {
        this.minimumOverallPercentage = minimumOverallPercentage;
    }

    public int getCreditHourTolerance() {
        return creditHourTolerance;
    }

    public void setCreditHourTolerance(int creditHourTolerance) {
        this.creditHourTolerance = creditHourTolerance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
