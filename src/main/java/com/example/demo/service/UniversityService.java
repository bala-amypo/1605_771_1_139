package com.example.demo.service.impl;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository repo;

    public UniversityServiceImpl(UniversityRepository repo) { this.repo = repo; }

    @Override
    public University createUniversity(University u) {
        if (u.getName() == null || u.getName().isEmpty()) {
            throw new IllegalArgumentException("Name required");
        }
        return repo.save(u);
    }

    @Override
    public University getUniversityById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("University not found"));
    }

    @Override
    public List<University> getAllUniversities() { return repo.findAll(); }

    @Override
    public University updateUniversity(Long id, University u) {
        University existing = getUniversityById(id);
        existing.setName(u.getName());
        existing.setLocation(u.getLocation());
        return repo.save(existing);
    }

    @Override
    public void deactivateUniversity(Long id) {
        University existing = getUniversityById(id);
        existing.setActive(false);
        repo.save(existing);
    }
}