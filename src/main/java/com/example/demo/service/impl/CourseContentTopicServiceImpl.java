package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.repository.CourseContentTopicRepository;
import com.example.demo.service.CourseContentTopicService;
import com.example.demo.service.CourseService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseContentTopicServiceImpl implements CourseContentTopicService {

    @Autowired private CourseContentTopicRepository topicRepository;
    @Autowired private CourseService courseService;

    @Override
    public CourseContentTopic addTopic(Long courseId, CourseContentTopic topic) {
        Course course = courseService.getCourseById(courseId);
        topic.setCourse(course);
        return topicRepository.save(topic);
    }

    @Override
    public List<CourseContentTopic> getTopicsByCourseId(Long courseId) {
        return topicRepository.findByCourseId(courseId);
    }

    @Override
    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}