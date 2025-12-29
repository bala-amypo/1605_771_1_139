package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    public void setEmail(String email) {
    this.email = email;
}

public String getEmail() {
    return email;
}

public void setPassword(String password) {
    this.password = password;
}

public String getPassword() {
    return password;
}
}