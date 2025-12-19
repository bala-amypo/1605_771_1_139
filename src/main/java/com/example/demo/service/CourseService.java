package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Course;

public interface CourseService {
    Course create(Course course);
    Course getById(Long id);
    Course getByCode(String code);
    List<Course> getAll();
    Course update(Long id, Course course);
    void delete(Long id);
}
