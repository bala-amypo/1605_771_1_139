package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University createUniversity(University university) {
        university.setActive(true);
        return universityRepository.save(university);
    }

    @Override
    public University updateUniversity(Long id, University university) {
        Optional<University> optional = universityRepository.findById(id);

        if (optional.isPresent()) {
            University existing = optional.get();
            existing.setName(university.getName());
            existing.setActive(university.isActive());
            return universityRepository.save(existing);
        }
        return null;
    }

    @Override
    public University getUniversityById(Long id) {
        return universityRepository.findById(id).orElse(null);
    }

    @Override
    public List<University> getAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }

    // REQUIRED METHOD
    @Override
    public void deactivateUniversity(Long id) {
        Optional<University> optional = universityRepository.findById(id);
        if (optional.isPresent()) {
            University university = optional.get();
            university.setActive(false);
            universityRepository.save(university);
        }
    }
}
