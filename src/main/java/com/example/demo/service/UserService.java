package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
    User getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
}
