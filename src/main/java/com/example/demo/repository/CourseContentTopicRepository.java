package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.CourseContentTopic;

public interface CourseContentTopicRepository {

    Optional<CourseContentTopic> findById(Long id);

    List<CourseContentTopic> findByCourseId(Long courseId);

    CourseContentTopic save(CourseContentTopic topic);
}
