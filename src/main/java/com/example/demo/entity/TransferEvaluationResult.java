package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double overlapPercentage;

    private boolean eligible;

    @ManyToOne
    private Course sourceCourse;

    @ManyToOne
    private Course targetCourse;


    public Long getId() {
        return id;
    }

    public double getOverlapPercentage() {
        return overlapPercentage;
    }

    public void setOverlapPercentage(double overlapPercentage) {
        this.overlapPercentage = overlapPercentage;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public Course getSourceCourse() {
        return sourceCourse;
    }

    public void setSourceCourse(Course sourceCourse) {
        this.sourceCourse = sourceCourse;
    }

    public Course getTargetCourse() {
        return targetCourse;
    }

    public void setTargetCourse(Course targetCourse) {
        this.targetCourse = targetCourse;
    }
    
}
