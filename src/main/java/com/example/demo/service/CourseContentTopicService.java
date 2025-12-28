package com.example.demo.service;

import com.example.demo.entity.CourseContentTopic;
import java.util.List;

public interface CourseContentTopicService {

    CourseContentTopic createTopic(CourseContentTopic topic);

    CourseContentTopic getTopicById(Long id);

    List<CourseContentTopic> getTopicsForCourse(Long courseId);

    void deleteTopic(Long id);
}
