package com.example.demo.service.impl;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.CourseService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;
    
    @Autowired
    private UniversityRepository universityRepo;

    @Override
    public Course createCourse(Course c) {
        if (c.getCreditHours() <= 0) {
            throw new IllegalArgumentException("Credit hours must be > 0");
        }
        // Verify University exists
        universityRepo.findById(c.getUniversity().getId())
            .orElseThrow(() -> new ResourceNotFoundException("University not found"));

        return courseRepo.save(c);
    }

    @Override
    public Course updateCourse(Long id, Course c) {
        Course existing = getCourseById(id);
        existing.setCourseCode(c.getCourseCode());
        existing.setCourseName(c.getCourseName());
        existing.setCreditHours(c.getCreditHours());
        existing.setDescription(c.getDescription());
        return courseRepo.save(existing);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    @Override
    public List<Course> getCoursesByUniversity(Long universityId) {
        return courseRepo.findByUniversityId(universityId);
    }

    @Override
    public void deactivateCourse(Long id) {
        Course c = getCourseById(id);
        c.setActive(false);
        courseRepo.save(c);
    }
}