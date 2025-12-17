package com.example.demo.entity;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class University {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String accreditationLevel;
    private String country;
    private Boolean active;
}
