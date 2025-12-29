package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
    User findByEmail(String email);
    boolean existsByEmail(String email);
    User registerUser(String email, String password);
}
