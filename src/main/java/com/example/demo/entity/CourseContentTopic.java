package com.example.demo.entity;

public class CourseContentTopic {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Course course;
    private String topicName;
    private Double weightPercentage;
}
