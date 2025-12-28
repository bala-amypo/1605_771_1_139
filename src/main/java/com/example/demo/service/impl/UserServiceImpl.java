package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University updateUniversity(Long id, University university) {
        university.setId(id);
        return universityRepository.save(university);
    }

    @Override
    public University getUniversityById(Long id) {
        return universityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }

    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University deactivateUniversity(Long id) {
        University university = universityRepository.findById(id).orElse(null);
        if (university != null) {
            university.setActive(false); // deactivate
            universityRepository.save(university);
        }
        return university;
    }
}
