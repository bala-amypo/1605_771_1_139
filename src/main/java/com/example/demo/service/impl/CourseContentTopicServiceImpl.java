package com.example.demo.service.impl;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.service.CourseContentTopicService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {
    private final CourseContentTopicRepository repo;

    public CourseContentTopicServiceImpl(CourseContentTopicRepository repo) { this.repo = repo; }

    @Override
    public CourseContentTopic createTopic(CourseContentTopic t) {
        validateWeight(t.getWeightPercentage());
        return repo.save(t);
    }

    @Override
    public CourseContentTopic updateTopic(Long id, CourseContentTopic t) {
        CourseContentTopic existing = getTopicById(id);
        validateWeight(t.getWeightPercentage());
        existing.setTopicName(t.getTopicName());
        existing.setWeightPercentage(t.getWeightPercentage());
        return repo.save(existing);
    }

    @Override
    public CourseContentTopic getTopicById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    @Override
    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        return repo.findByCourseId(courseId);
    }

    @Override
    public void deleteTopic(Long id) {
        if(!repo.existsById(id)) throw new RuntimeException("Topic not found");
        repo.deleteById(id);
    }

    private void validateWeight(double w) {
        if(w < 0 || w > 100) throw new IllegalArgumentException("Weight must be 0-100");
    }
}