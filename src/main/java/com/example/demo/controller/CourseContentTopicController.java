package com.example.demo.controller;

import com.example.demo.entity.CourseContentTopic;
import com.example.demo.service.CourseContentTopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class CourseContentTopicController {

    @Autowired
    private CourseContentTopicService service;

    @PostMapping
    public CourseContentTopic create(@RequestBody CourseContentTopic topic) {
        return service.createTopic(topic);
    }

    @GetMapping("/{id}")
    public CourseContentTopic getById(@PathVariable Long id) {
        return service.getTopicById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<CourseContentTopic> getByCourse(@PathVariable Long courseId) {
        return service.getTopicsForCourse(courseId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTopic(id);
    }
}
