package com.example.demo.service;

import com.example.demo.entity.CourseContentTopic; // Make sure this import matches your package
import java.util.List;

public interface CourseContentTopicService {
    // Other methods...
    
    // CHANGE return type from String to CourseContentTopic
    CourseContentTopic getTopicById(Long id); 
}