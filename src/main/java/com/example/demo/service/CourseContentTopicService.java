package com.example.demo.service;
import com.example.demo.entity.CourseContentTopic;
import java.util.List;

public interface CourseContentTopicService {
    CourseContentTopic createTopic(CourseContentTopic t);
    CourseContentTopic updateTopic(Long id, CourseContentTopic t);
     getTopicById(Long id);
    String getTopicById(Long id);
    List<CourseContentTopic> getTopicsForCourse(Long courseId);
    void deleteTopic(Long id);
}