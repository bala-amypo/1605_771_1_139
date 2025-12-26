package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String courseName;
    private String university;
    private int creditHours;
    private String description;
    private boolean active = true;

    // Explicit Getters to ensure other services can find them
    public Long getId() { return id; }
    public String getCourseCode() { return courseCode; }
    public String getUniversity() { return university; }
    public int getCreditHours() { return creditHours; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public String getCourseName() { return courseName; }
}