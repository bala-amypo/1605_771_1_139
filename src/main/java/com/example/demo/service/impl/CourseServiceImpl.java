package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
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
    public Course updateCourse(Long id, Course course) {
        Course existing = getCourseById(id);
        if (existing != null) {
            existing.setCourseName(course.getCourseName());
            existing.setCourseCode(course.getCourseCode());
            existing.setCreditHours(course.getCreditHours());
            existing.setDescription(course.getDescription());
            existing.setActive(course.isActive());
            return courseRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
    
    // Helper method if interface requires just getAll() without filter
    // or checks for university
    public List<Course> getCoursesByUniversity(Long universityId) {
        return courseRepository.findByUniversityId(universityId);
    }
}