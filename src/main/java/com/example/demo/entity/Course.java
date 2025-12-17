package com.example.demo.entity;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"university_id","courseCode"}))
public class Course {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private University university;
    private String courseCode;
    private String courseName;
    private Integer creditHours;
    private String description;
    private String department;
    private Boolean active;
}
