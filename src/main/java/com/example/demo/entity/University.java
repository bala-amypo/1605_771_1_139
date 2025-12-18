package com.example.demo.entity;

@Entity
public class University {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String accreditationLevel;
    private String country;
    private Boolean active;
}
