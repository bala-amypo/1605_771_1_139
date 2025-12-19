package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.University;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UniversityRepository;
import com.example.demo.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repository;

    public UniversityServiceImpl(UniversityRepository repository) {
        this.repository = repository;
    }

    @Override
    public University create(University university) {
        return repository.save(university);
    }

    @Override
    public University getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("university not found"));
    }

    @Override
    public List<University> getAll() {
        return repository.findAll();
    }

    @Override
    public University update(Long id, University university) {
        University existing = getById(id);
        existing.setName(university.getName());
        existing.setCountry(university.getCountry());
        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        University existing = getById(id);
        repository.delete(existing);
    }
}
