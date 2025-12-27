package com.example.demo.service;
import com.example.demo.entity.Course;
import java.util.List;

public interface CourseService {
    
    void deactivateCourse(Long id);
    Course createCourse(Course c);
    Course getCourseById(Long id);
    List<Course> getCoursesByUniversity(Long universityId);
    
}