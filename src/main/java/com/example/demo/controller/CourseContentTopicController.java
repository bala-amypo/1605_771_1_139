package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.service.CourseContentTopicService;

@RestController
@RequestMapping("/api/topics")
@Tag(name = "Course Content Topic")
public class CourseContentTopicController {

    @PostMapping
    public CourseContentTopic create(@RequestBody CourseContentTopic topic) {
        return null;
    }

    @PutMapping("/{id}")
    public CourseContentTopic update(@PathVariable Long id,
                                     @RequestBody CourseContentTopic topic) {
        return null;
    }

    @GetMapping("/{id}")
    public CourseContentTopic getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/course/{courseId}")
    public List<CourseContentTopic> getByCourse(@PathVariable Long courseId) {
        return null;
    }
}
