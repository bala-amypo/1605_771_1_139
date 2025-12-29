package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University createUniversity(University university) {
        university.setActive(true);
        return universityRepository.save(university);
    }

    @Override
    public University getUniversity(Long id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("University not found"));
    }

    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University updateUniversity(Long id, University university) {
        University existing = getUniversity(id);
        existing.setName(university.getName());
        existing.setActive(university.isActive());
        return universityRepository.save(existing);
    }

    @Override
    public void deactivateUniversity(Long id) {
        University university = getUniversity(id);
        university.setActive(false);
        universityRepository.save(university);
    }
}
