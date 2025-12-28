package com.example.demo.service.impl;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.service.CourseContentTopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    @Autowired
    private CourseContentTopicRepository repository;

    @Override
    public CourseContentTopic createTopic(CourseContentTopic topic) {
        return repository.save(topic);
    }

    @Override
    public CourseContentTopic getTopicById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        return repository.findByCourseId(courseId);
    }

    @Override
    public void deleteTopic(Long id) {
        repository.deleteById(id);
    }
}
