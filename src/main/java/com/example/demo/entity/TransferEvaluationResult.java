package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class TransferEvaluationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Course sourceCourse;

    @ManyToOne
    private Course targetCourse;

    private boolean eligible;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }
}
