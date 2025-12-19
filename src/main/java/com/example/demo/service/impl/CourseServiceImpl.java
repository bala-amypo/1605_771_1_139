package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Course;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course create(Course course) {
        return repository.save(course);
    }

    @Override
    public Course getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("course not found"));
    }

    @Override
    public Course getByCode(String code) {
        return repository.findByCodeIgnoreCase(code)
                .orElseThrow(() -> new ResourceNotFoundException("course not found"));
    }

    @Override
    public List<Course> getAll() {
        return repository.findAll();
    }

    @Override
    public Course update(Long id, Course course) {
        Course existing = getById(id);
        existing.setCode(course.getCode());
        existing.setTitle(course.getTitle());
        existing.setCredits(course.getCredits());
        return repository.save(
