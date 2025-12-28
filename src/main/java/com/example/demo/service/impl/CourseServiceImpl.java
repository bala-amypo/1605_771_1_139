package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        course.setActive(true);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Optional<Course> optional = courseRepository.findById(id);

        if (optional.isPresent()) {
            Course existing = optional.get();
            existing.setCourseName(course.getCourseName());
            existing.setUniversity(course.getUniversity());
            existing.setActive(course.isActive());
            return courseRepository.save(existing);
        }
        return null;
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
