package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.*;

public interface UniversityRepository {
    Optional<University> findById(Long id);
    Optional<University> findByName(String name);
    University save(University u);
}
