package com.example.demo.service.impl;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository; // Check exact repo name in your project
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseContentTopicService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    @Autowired
    private CourseContentTopicRepository topicRepo;
    
    @Autowired
    private CourseRepository courseRepo;

    @Override
    public CourseContentTopic createTopic(CourseContentTopic t) {
        if (t.getTopicName() == null || t.getTopicName().isEmpty()) {
            throw new IllegalArgumentException("Topic name cannot be empty");
        }
        if (t.getWeightPercentage() < 0 || t.getWeightPercentage() > 100) {
            throw new IllegalArgumentException("Weight must be 0-100");
        }
        courseRepo.findById(t.getCourse().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
            
        return topicRepo.save(t);
    }

    @Override
    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        return topicRepo.findByCourseId(courseId);
    }

    @Override
    public CourseContentTopic getTopicById(Long id) {
        return topicRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
    }

    @Override
    public CourseContentTopic updateTopic(Long id, CourseContentTopic t) {
        CourseContentTopic existing = getTopicById(id);
        existing.setTopicName(t.getTopicName());
        existing.setWeightPercentage(t.getWeightPercentage());
        return topicRepo.save(existing);
    }
}