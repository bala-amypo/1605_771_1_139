package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.service.CourseContentTopicService;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    private final CourseContentTopicRepository repository;

    public CourseContentTopicServiceImpl(CourseContentTopicRepository repository) {
        this.repository = repository;
    }

    @Override
    public CourseContentTopic create(CourseContentTopic topic) {
        return repository.save(topic);
    }

    @Override
    public CourseContentTopic getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("topic not found"));
    }

    @Override
    public List<CourseContentTopic> getAll() {
        return repository.findAll();
    }

    @Override
    public CourseContentTopic update(Long id, CourseContentTopic topic) {
        CourseContentTopic existing = getById(id);
        existing.setName(topic.getName());
        existing.setDescription(topic.getDescription());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        CourseContentTopic existing = getById(id);
        repository.delete(existing);
    }
}
