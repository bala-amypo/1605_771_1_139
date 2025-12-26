package com.example.demo.service.impl;

import java.util.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class CourseServiceImpl {

    public CourseRepository repo;
    public UniversityRepository univRepo;

    public Course createCourse(Course c) {
        if (c.getCreditHours() <= 0)
            throw new IllegalArgumentException("> 0");

        Long uid = c.getUniversity().getId();
        univRepo.findById(uid).orElseThrow();

        repo.findByUniversityIdAndCourseCode(uid, c.getCourseCode())
                .ifPresent(x -> { throw new IllegalArgumentException(); });

        return repo.save(c);
    }

    public void deactivateCourse(Long id) {
        Course c = repo.findById(id).orElseThrow();
        c.setActive(false);
        repo.save(c);
    }

    public Course updateCourse(Long id, Course c) {
        Course ex = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        return repo.save(ex);
    }

    public Course getCourseById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Course> getCoursesByUniversity(Long uid) {
        return repo.findByUniversityIdAndActiveTrue(uid);
    }
}
