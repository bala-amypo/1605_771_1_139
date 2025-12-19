package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
    Optional<University> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCase(String name);
}
