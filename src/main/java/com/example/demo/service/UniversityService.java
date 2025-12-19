package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.University;

public interface UniversityService {
    University create(University university);
    University getById(Long id);
    List<University> getAll();
    University update(Long id, University university);
    void delete(Long id);
}
