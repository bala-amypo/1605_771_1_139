package com.example.demo.service.impl;

import com.example.demo.model.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import com.example.demo.exception.ResourceNotFoundException; // Assuming you have this, otherwise use RuntimeException
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepo;

    @Override
    public University createUniversity(University u) {
        if (universityRepo.findByName(u.getName()).isPresent()) {
            throw new IllegalArgumentException("University with this name already exists");
        }
        // active defaults to true in entity, but safe to set here if needed
        if (u.getActive() == null) u.setActive(true);
        return universityRepo.save(u);
    }

    @Override
    public University updateUniversity(Long id, University u) {
        University existing = getUniversityById(id);
        existing.setName(u.getName());
        existing.setAccreditationLevel(u.getAccreditationLevel());
        existing.setCountry(u.getCountry());
        return universityRepo.save(existing);
    }

    @Override
    public University getUniversityById(Long id) {
        return universityRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("University not found"));
    }

    @Override
    public List<University> getAllUniversities() {
        return universityRepo.findAll();
    }

    @Override
    public void deactivateUniversity(Long id) {
        University u = getUniversityById(id);
        u.setActive(false);
        universityRepo.save(u);
    }
}