package com.example.demo.service.impl;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository; // Ensure you have this Repo created!
import com.example.demo.service.CourseContentTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    @Autowired
    private CourseContentTopicRepository topicRepository;

    @Override
    public CourseContentTopic createTopic(CourseContentTopic topic) {
        return topicRepository.save(topic);
    }

    @Override
    public CourseContentTopic updateTopic(Long id, CourseContentTopic topic) {
        CourseContentTopic existing = getTopicById(id);
        if (existing != null) {
            existing.setTopicName(topic.getTopicName());
            existing.setWeightPercentage(topic.getWeightPercentage());
            return topicRepository.save(existing);
        }
        return null;
    }

    @Override
    public CourseContentTopic getTopicById(Long id) {
        return topicRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public List<CourseContentTopic> getAllTopics() {
        return topicRepository.findAll();
    }

    // Implementing the missing method
    @Override
    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        return topicRepository.findByCourseId(courseId); // Ensure your Repository has findByCourseId
    }
}