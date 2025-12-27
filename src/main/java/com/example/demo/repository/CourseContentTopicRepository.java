package com.example.demo.repository;
import com.example.demo.entity.CourseContentTopic;
mport org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TopicRepository extends JpaRepository<CourseContentTopic, Long> {
    List<CourseContentTopic> findByCourseId(Long courseId);
}