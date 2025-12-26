package com.example.demo.security;

import java.util.Set;

public class CustomUserDetails {

    private Long id;
    private String username;
    private String password;
    private Set<Role> roles;

    public CustomUserDetails(Long id, String username, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
