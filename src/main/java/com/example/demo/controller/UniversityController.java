package com.example.demo.controller;

import com.example.demo.entity.University;
import com.example.demo.repository.UniversityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

    @PostMapping
    public University create(@RequestBody University u) {
        return universityRepository.save(u);
    }

    @GetMapping
    public List<University> getAll() {
        return universityRepository.findAll();
    }
}
