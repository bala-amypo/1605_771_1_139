package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transfer_evaluation_results")
public class TransferEvaluationResult {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "source_university_id")
    private University sourceUniversity;
    
    @ManyToOne
    @JoinColumn(name = "target_university_id")
    private University targetUniversity;
    
    @ManyToOne
    @JoinColumn(name = "source_course_id")
    private Course sourceCourse;
    
    @ManyToOne
    @JoinColumn(name = "target_course_id")
    private Course targetCourse;
    
    @Column(name = "is_eligible")
    private Boolean isEligible = false;
    
    @OneToMany(mappedBy = "evaluationResult", cascade = CascadeType.ALL)
    private List<TransferEvaluationResult> eligibleCourses = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "evaluation_result_id")
    private TransferEvaluationResult evaluationResult;
    
    private String notes;
    
    // Default constructor
    public TransferEvaluationResult() {
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public University getSourceUniversity() {
        return sourceUniversity;
    }
    
    public void setSourceUniversity(University sourceUniversity) {
        this.sourceUniversity = sourceUniversity;
    }
    
    public University getTargetUniversity() {
        return targetUniversity;
    }
    
    public void setTargetUniversity(University targetUniversity) {
        this.targetUniversity = targetUniversity;
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
    
    public Boolean getIsEligible() {
        return isEligible;
    }
    
    public void setIsEligible(Boolean isEligible) {
        this.isEligible = isEligible;
    }
    
    // Setter with boolean parameter
    public void setEligible(boolean eligible) {
        this.isEligible = eligible;
    }
    
    public List<TransferEvaluationResult> getEligibleCourses() {
        return eligibleCourses;
    }
    
    public void setEligibleCourses(List<TransferEvaluationResult> eligibleCourses) {
        this.eligibleCourses = eligibleCourses;
    }
    public double getOverlapPercentage() {
    return overlapPercentage;
}

    // Method required by tests
    public List<TransferEvaluationResult> getIsEligibleForTransfer() {
        return this.eligibleCourses;
    }
    
    public String getNotes() {
        return notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    public TransferEvaluationResult getEvaluationResult() {
        return evaluationResult;
    }
    
    public void setEvaluationResult(TransferEvaluationResult evaluationResult) {
        this.evaluationResult = evaluationResult;
    }
    public void setEligible(boolean eligible) {
    this.eligible = eligible;
}

public boolean isEligible() {
    return eligible;
}

public void setOverlapPercentage(double overlapPercentage) {
    this.overlapPercentage = overlapPercentage;
}

}