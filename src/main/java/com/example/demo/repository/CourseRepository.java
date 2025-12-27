package com.example.demo.repository;
import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Used in Test 44 (Duplicate Check) and Test 30 (Negative Find)
    Optional<Course> findByUniversityIdAndCourseCode(Long universityId, String courseCode);
    
    // Used in Test 37 (Courses by University)
    List<Course> findByUniversityIdAndActiveTrue(Long universityId);
    
    // Fallback for generic find
    List<Course> findByUniversityId(Long universityId);
}