package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.University;
import com.example.demo.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Override
    public List<University> getAll() {
        return List.of();
    }
}
