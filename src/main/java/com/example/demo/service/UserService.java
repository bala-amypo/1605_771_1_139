package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    String login(String email, String password);
    User register(User user);
    User findByEmail(String email);
}