package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.repository.CourseRepository;

public class CourseContentTopicServiceImpl {

    private CourseContentTopicRepository repo;
    private CourseRepository courseRepo;

    public CourseContentTopic createTopic(CourseContentTopic t) {

        if (t.getTopicName() == null || t.getTopicName().isBlank())
            throw new IllegalArgumentException("Topic name required");

        if (t.getWeightPercentage() == null ||
            t.getWeightPercentage() < 0 ||
            t.getWeightPercentage() > 100)
            throw new IllegalArgumentException("Weight must be 0-100");

        Course c = courseRepo.findById(t.getCourse().getId())
                .orElseThrow(() -> new RuntimeException("not found"));

        t.setCourse(c);
        return repo.save(t);
    }

    public CourseContentTopic updateTopic(Long id, CourseContentTopic t) {
        CourseContentTopic existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        existing.setTopicName(t.getTopicName());
        existing.setWeightPercentage(t.getWeightPercentage());
        return repo.save(existing);
    }

    public CourseContentTopic getTopicById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<CourseContentTopic> getTopicsForCourse(Long courseId) {
        courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("not found"));
        return repo.findByCourseId(courseId);
    }
}
