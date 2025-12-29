package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "course_content_topics")
public class CourseContentTopic {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    
    private String topic;
    
    @Column(name = "weight_percentage")
    private Double weightPercentage;
    
    // Default constructor
    public CourseContentTopic() {
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course course) {
        this.course = course;
    }
    
   
    public void setTopicName(String topicName) {
    this.topicName = topicName;
}

public String getTopicName() {
    return topicName;
}

    public Double getWeightPercentage() {
        return weightPercentage;
    }
    
    public void setWeightPercentage(Double weightPercentage) {
        this.weightPercentage = weightPercentage;
    }
}