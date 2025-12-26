package com.example.demo.security;

import java.util.Set;

public class CustomUserDetails {

    private Long id;
    private String email;
    private String password;
    private Set<Role> roles;

    public CustomUserDetails(Long id, String email, String password, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
