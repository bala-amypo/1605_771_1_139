package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean eligible;
    private double overlapPercentage;

    public Long getId() {
        return id;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public double getOverlapPercentage() {
        return overlapPercentage;
    }

    public void setOverlapPercentage(double overlapPercentage) {
        this.overlapPercentage = overlapPercentage;
    }
}
