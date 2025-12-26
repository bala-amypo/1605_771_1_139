package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private University sourceUniversity;

    @ManyToOne(optional = false)
    private University targetUniversity;

    private double minimumOverlapPercentage;
    private int creditHourTolerance;
    private boolean active = true;

    public TransferRule() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public University getSourceUniversity() { return sourceUniversity; }
    public void setSourceUniversity(University sourceUniversity) { this.sourceUniversity = sourceUniversity; }

    public University getTargetUniversity() { return targetUniversity; }
    public void setTargetUniversity(University targetUniversity) { this.targetUniversity = targetUniversity; }

    public double getMinimumOverlapPercentage() { return minimumOverlapPercentage; }
    public void setMinimumOverlapPercentage(double minimumOverlapPercentage) { this.minimumOverlapPercentage = minimumOverlapPercentage; }

    public int getCreditHourTolerance() { return creditHourTolerance; }
    public void setCreditHourTolerance(int creditHourTolerance) { this.creditHourTolerance = creditHourTolerance; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}