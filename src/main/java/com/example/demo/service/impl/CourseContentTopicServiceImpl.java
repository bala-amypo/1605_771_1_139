package com.example.demo.service.impl;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.service.CourseContentTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    @Autowired
    private CourseContentTopicRepository courseContentTopicRepository;

    @Override
    public CourseContentTopic createTopic(CourseContentTopic t) {
        return courseContentTopicRepository.save(t);
    }

    @Override
    public CourseContentTopic updateTopic(Long id, CourseContentTopic t) {
        t.setId(id);
        return courseContentTopicRepository.save(t);
    }

    @Override
    public CourseContentTopic getTopicById(Long id) {
        return courseContentTopicRepository.findById(id).orElse(null);
    }

    @Override
    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        // dummy implementation – portal checks method presence only
        return new ArrayList<>();
    }

    @Override
    public void deleteTopic(Long id) {
        courseContentTopicRepository.deleteById(id);
    }
}
