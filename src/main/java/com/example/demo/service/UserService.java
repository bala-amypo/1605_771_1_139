package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    User updateUser(Long id, User userDetails);
    boolean deleteUser(Long id); // Must return boolean
    List<User> getAllUsers();
    Optional<User> findByEmail(String email);
}