package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;


public interface CourseContentTopicRepository {
    Optional<CourseContentTopic> findById(Long id);
    List<CourseContentTopic> findByCourseId(Long cid);
    CourseContentTopic save(CourseContentTopic t);
}
