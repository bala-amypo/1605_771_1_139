package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double overlapPercentage;

    public Long getId() {
        return id;
    }

    public double getOverlapPercentage() {
        return overlapPercentage;
    }

    public void setOverlapPercentage(double overlapPercentage) {
        this.overlapPercentage = overlapPercentage;
    }
}
