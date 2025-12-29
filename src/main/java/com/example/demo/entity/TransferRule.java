package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transfer_rules")
public class TransferRule {
    
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
    
    @Column(name = "credit_hour_tolerance")
    private Integer creditHourTolerance;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    // Default constructor
    public TransferRule() {
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
    
    public Integer getCreditHourTolerance() {
        return creditHourTolerance;
    }
    
    public void setCreditHourTolerance(Integer creditHourTolerance) {
        this.creditHourTolerance = creditHourTolerance;
    }
    
    public Boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    
    // Method for boolean check
    public Boolean isActive() {
        return this.isActive;
    }
    
    // Setter with boolean parameter
    public void setActive(boolean active) {
        this.isActive = active;
    }
  private Double minimumOverlapPercentage;

public Double getMinimumOverlapPercentage() {
    return minimumOverlapPercentage;
}

public void setMinimumOverlapPercentage(Double minimumOverlapPercentage) {
    this.minimumOverlapPercentage = minimumOverlapPercentage;
}

}