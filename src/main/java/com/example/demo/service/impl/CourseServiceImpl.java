package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.University;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UniversityRepository;

public class CourseServiceImpl {

    private CourseRepository repo;
    private UniversityRepository univRepo;

    public Course createCourse(Course c) {
        if (c.getCreditHours() <= 0)
            throw new IllegalArgumentException("Credit hours must be > 0");

        if (c.getUniversity() == null || c.getUniversity().getId() == null)
            throw new IllegalArgumentException("University required");

        University u = univRepo.findById(c.getUniversity().getId())
                .orElseThrow(() -> new RuntimeException("not found"));

        if (repo.findByUniversityIdAndCourseCode(u.getId(), c.getCourseCode()).isPresent())
            throw new IllegalArgumentException("Duplicate course code");

        c.setUniversity(u);
        return repo.save(c);
    }

    public Course updateCourse(Long id, Course c) {
        Course existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        existing.setCourseName(c.getCourseName());
        existing.setCreditHours(c.getCreditHours());
        return repo.save(existing);
    }

    public Course getCourseById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public void deactivateCourse(Long id) {
        Course c = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        c.setActive(false);
        repo.save(c);
    }

    public List<Course> getCoursesByUniversity(Long universityId) {
        return repo.findByUniversityIdAndActiveTrue(universityId);
    }
}
