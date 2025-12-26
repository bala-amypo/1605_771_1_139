package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Course;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping
    public List<Course> getAllCourses() {
        return List.of();
    }
}
