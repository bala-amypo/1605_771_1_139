package com.example.demo.service;

import com.example.demo.entity.University;
import java.util.List;

public interface UniversityService {

    University createUniversity(University university);

    University getUniversityById(Long id);

    List<University> getAllUniversities();

    void deleteUniversity(Long id);
}
