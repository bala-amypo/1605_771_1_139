package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Course create(@RequestBody Course c) {
        return courseRepository.save(c);
    }

    @GetMapping
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
