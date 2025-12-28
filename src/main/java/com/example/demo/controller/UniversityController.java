package com.example.demo.controller;

import com.example.demo.entity.University;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    // Create a new university
    @PostMapping
    public ResponseEntity<University> createUniversity(@RequestBody University university) {
        University created = universityService.createUniversity(university);
        return ResponseEntity.ok(created);
    }

    // Get all universities
    @GetMapping
    public ResponseEntity<List<University>> getAllUniversities() {
        List<University> list = universityService.getAllUniversities();
        return ResponseEntity.ok(list);
    }

    // Get a university by ID
    @GetMapping("/{id}")
    public ResponseEntity<University> getUniversityById(@PathVariable Long id) {
        University university = universityService.getUniversityById(id);
        if (university == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(university);
    }

    // Update a university
    @PutMapping("/{id}")
    public ResponseEntity<University> updateUniversity(@PathVariable Long id, @RequestBody University university) {
        University updated = universityService.updateUniversity(id, university);
        return ResponseEntity.ok(updated);
    }

    // Delete a university
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }

    // Deactivate a university
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<University> deactivateUniversity(@PathVariable Long id) {
        University deactivated = universityService.deactivateUniversity(id);
        if (deactivated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deactivated);
    }
}
