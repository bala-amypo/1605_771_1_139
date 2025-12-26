package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class CourseContentTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Course course;

    private String topicName;
    private double weightPercentage;

    public CourseContentTopic() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public double getWeightPercentage() { return weightPercentage; }
    public void setWeightPercentage(double weightPercentage) { this.weightPercentage = weightPercentage; }
}