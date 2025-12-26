package com.example.demo.entity;

public class CourseContentTopic {
    private Long id;
    private String topicName;
    private Double weightPercentage;
    private Course course;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public Double getWeightPercentage() { return weightPercentage; }
    public void setWeightPercentage(Double weightPercentage) { this.weightPercentage = weightPercentage; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
