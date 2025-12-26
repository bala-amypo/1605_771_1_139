package com.example.demo.controller;

import com.example.demo.entity.University;
import com.example.demo.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {
    private final UniversityService service;

    public UniversityController(UniversityService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<University> create(@RequestBody University u) {
        return ResponseEntity.ok(service.createUniversity(u));
    }

    @GetMapping
    public List<University> getAll() { return service.getAllUniversities(); }

    @GetMapping("/{id}")
    public University getById(@PathVariable Long id) { return service.getUniversityById(id); }
}