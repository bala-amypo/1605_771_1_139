package com.example.demo.repository;

import com.example.demo.entity.CourseContentTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseContentTopicRepository
        extends JpaRepository<CourseContentTopic, Long> {

    // 🔥 REQUIRED FOR PORTAL TESTS
    List<CourseContentTopic> findByCourseId(Long courseId);

    // (Optional but safe for JPA navigation)
    List<CourseContentTopic> findByCourse_Id(Long courseId);
}
