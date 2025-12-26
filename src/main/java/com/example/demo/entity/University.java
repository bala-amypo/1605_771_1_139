package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class University {

    @Id
    private Long id;
    private String name;
    private String country;

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }
}
