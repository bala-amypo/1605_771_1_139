package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.CourseContentTopic;

public interface CourseContentTopicRepository extends JpaRepository<CourseContentTopic, Long> {
    Optional<CourseContentTopic> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
