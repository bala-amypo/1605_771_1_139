package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User registerUser(User user);
    User updateUser(Long id, User userDetails);
    boolean deleteUser(Long id);
}