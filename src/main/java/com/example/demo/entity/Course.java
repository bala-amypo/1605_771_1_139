package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Table(name = "courses")
@Data
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private String courseName;
    private double creditHours;
    private boolean active = true;

    @ManyToOne
    private University university;
}