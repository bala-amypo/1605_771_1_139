package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.University;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @GetMapping
    public List<University> getAll() {
        return List.of();
    }
}
