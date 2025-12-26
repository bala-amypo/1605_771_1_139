package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Course;

public interface CourseRepository {

    Optional<Course> findById(Long id);

    Optional<Course> findByUniversityIdAndCourseCode(Long universityId, String courseCode);

    List<Course> findByUniversityIdAndActiveTrue(Long universityId);

    Course save(Course course);
}
