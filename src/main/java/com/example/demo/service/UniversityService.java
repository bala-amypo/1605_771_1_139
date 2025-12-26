package com.example.demo.service;
import com.example.demo.entity.University;
import java.util.List;

public interface UniversityService {
    University createUniversity(University u);
    University getUniversityById(Long id);
    List<University> getAllUniversities();
    University updateUniversity(Long id, University u);
    void deactivateUniversity(Long id);
}