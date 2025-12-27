package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseCode;
    private String courseName;
    private int creditHours;
    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
}