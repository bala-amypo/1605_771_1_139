package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course c) {
        return ResponseEntity.ok(service.createCourse(c));
    }

    @GetMapping("/university/{univId}")
    public List<Course> getByUniversity(@PathVariable Long univId) {
        return service.getCoursesByUniversity(univId);
    }
}