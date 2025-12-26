package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User findByEmail(String email);

    User registerUser(User user);

    User updateUser(Long id, User userDetails);

    boolean deleteUser(Long id);
}
