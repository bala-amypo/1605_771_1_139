package com.example.demo.controller;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.service.CourseContentTopicService; // Ensure interface name matches
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    // Note: Assuming the service interface is named 'TopicService' or 'CourseContentTopicService'
    // Adjust variable type based on your service interface name
    @Autowired
    private TopicService topicService; 

    @PostMapping
    public ResponseEntity<CourseContentTopic> createTopic(@RequestBody CourseContentTopic topic) {
        return ResponseEntity.ok(topicService.createTopic(topic));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<CourseContentTopic>> getTopicsByCourse(@PathVariable Long courseId) {
        // You might need to add this method to your Service Interface if missing
        return ResponseEntity.ok(topicService.getTopicsForCourse(courseId)); 
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CourseContentTopic> getTopicById(@PathVariable Long id) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }
}