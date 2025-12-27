package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;
    
    @Autowired
    private UniversityRepository universityRepo;

    public Course createCourse(Course c) {
        Long uniId = c.getUniversity().getId();
        // Check if uni exists
        universityRepo.findById(uniId)
            .orElseThrow(() -> new IllegalArgumentException("University not found"));
            
        // Check for duplicates
        if (courseRepo.findByUniversityIdAndCourseCode(uniId, c.getCourseCode()).isPresent()) {
            throw new IllegalArgumentException("Duplicate course code");
        }
        return courseRepo.save(c);
    }

    public List<Course> getCoursesByUniversity(Long uniId) {
        return courseRepo.findByUniversityIdAndActiveTrue(uniId);
    }
    
    public Course getCourseById(Long id) {
        return courseRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Course not found"));
    }
}
