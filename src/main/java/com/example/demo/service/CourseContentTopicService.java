package com.example.demo.service;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepo;
    
    @Autowired
    private CourseRepository courseRepo;

    public CourseContentTopic createTopic(CourseContentTopic t) {
        courseRepo.findById(t.getCourse().getId())
            .orElseThrow(() -> new RuntimeException("Course not found"));
            
        if (t.getWeightPercentage() < 0 || t.getWeightPercentage() > 100) {
            throw new IllegalArgumentException("Weight must be 0-100");
        }
        return topicRepo.save(t);
    }

    public CourseContentTopic updateTopic(Long id, CourseContentTopic updated) {
        CourseContentTopic existing = topicRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Topic not found"));
        
        existing.setTopicName(updated.getTopicName());
        existing.setWeightPercentage(updated.getWeightPercentage());
        return topicRepo.save(existing);
    }
    
    public CourseContentTopic getTopicById(Long id) {
        return topicRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Topic not found"));
    }
}
