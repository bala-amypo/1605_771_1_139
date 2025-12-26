package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    private Long id;
    private String name;
    private int credits;

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
}
