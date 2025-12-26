package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.University;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/universities")
@Tag(name = "University")
public class UniversityController {

    @PostMapping
    public University create(@RequestBody University university) {
        return null;
    }

    @PutMapping("/{id}")
    public University update(@PathVariable Long id,
                             @RequestBody University university) {
        return null;
    }

    @GetMapping("/{id}")
    public University getById(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public List<University> getAll() {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
    }
}
