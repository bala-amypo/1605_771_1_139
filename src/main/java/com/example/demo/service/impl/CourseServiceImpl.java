package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repo;

    public CourseServiceImpl(CourseRepository repo) { this.repo = repo; }

    @Override
    public Course createCourse(Course c) {
        if(c.getUniversity() == null || c.getUniversity().getId() == null)
            throw new IllegalArgumentException("University required");
            
        // Check for duplicate course code in same university
        if(repo.findByUniversityIdAndCourseCode(c.getUniversity().getId(), c.getCourseCode()).isPresent()) {
            throw new IllegalArgumentException("Duplicate Course Code");
        }
        return repo.save(c);
    }

    @Override
    public Course getCourseById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public List<Course> getCoursesByUniversity(Long universityId) {
        return repo.findByUniversityIdAndActiveTrue(universityId);
    }

    @Override
    public void deactivateCourse(Long id) {
        Course c = getCourseById(id);
        c.setActive(false);
        repo.save(c);
    }
}