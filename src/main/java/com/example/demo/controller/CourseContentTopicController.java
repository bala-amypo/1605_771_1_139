package com.example.demo.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.CourseContentTopic;
import com.example.demo.service.CourseContentTopicService;

@RestController
@RequestMapping("/course-content-topics")
public class CourseContentTopicController {

    private final CourseContentTopicService service;

    public CourseContentTopicController(CourseContentTopicService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CourseContentTopic> create(@RequestBody CourseContentTopic topic) {
        return new ResponseEntity<>(service.create(topic), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseContentTopic> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseContentTopic>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseContentTopic> update(
            @PathVariable Long id,
            @RequestBody CourseContentTopic topic) {
        return ResponseEntity.ok(service.update(id, topic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
