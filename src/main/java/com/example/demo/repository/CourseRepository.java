package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;


public interface CourseRepository {
    Optional<Course> findById(Long id);
    Optional<Course> findByUniversityIdAndCourseCode(Long uid, String code);
    List<Course> findByUniversityIdAndActiveTrue(Long uid);
    Course save(Course c);
}
