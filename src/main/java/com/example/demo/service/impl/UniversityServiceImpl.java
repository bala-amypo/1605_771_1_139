package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class UniversityServiceImpl {

    public UniversityRepository repository;

    public University createUniversity(University u) {
        if (u.getName() == null || u.getName().isBlank())
            throw new IllegalArgumentException("Name required");
        repository.findByName(u.getName()).ifPresent(x -> {
            throw new IllegalArgumentException("University already exists");
        });
        return repository.save(u);
    }

    public University updateUniversity(Long id, University u) {
        University ex = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        ex.setName(u.getName());
        return repository.save(ex);
    }

    public University getUniversityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public void deactivateUniversity(Long id) {
        University u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
        u.setActive(false);
        repository.save(u);
    }
}
