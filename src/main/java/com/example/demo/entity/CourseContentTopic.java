package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CourseContentTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topicName;
    private double weightPercentage; // 0 to 100

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}