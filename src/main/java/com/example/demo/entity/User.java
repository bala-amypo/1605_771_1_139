package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    public User(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}