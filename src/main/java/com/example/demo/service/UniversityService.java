package com.example.demo.service;

import com.example.demo.entity.University;
import java.util.List;

public interface UniversityService {

    University createUniversity(University university);

    University getUniversity(Long id);

    List<University> getAllUniversities();

    University updateUniversity(Long id, University university);

    void deactivateUniversity(Long id);
}
