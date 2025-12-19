package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;


public interface UniversityRepository extends JpaRepository<University, Long> {
    boolean existsByNameIgnoreCase(String name);
}
