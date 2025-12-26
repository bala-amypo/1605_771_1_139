package com.example.demo.service;

import com.example.demo.entity.Course;
import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    void deleteCourse(Long id);
    List<Course> getCoursesByUniversity(String university);
}