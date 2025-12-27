package com.example.demo.service;
import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepo;

    public University createUniversity(University u) {
        if (u.getName() == null || u.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name required");
        }
        return universityRepo.save(u);
    }

    public void deactivateUniversity(Long id) {
        University u = universityRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("University not found"));
        u.setActive(false);
        universityRepo.save(u);
    }
}
