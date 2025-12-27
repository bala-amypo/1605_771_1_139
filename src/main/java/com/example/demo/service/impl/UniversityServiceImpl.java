package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    // Updated to handle Optional return from Repository
    @Override
    public User login(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.orElse(null); 
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingOpt = userRepository.findById(id);
        if (existingOpt.isPresent()) {
            User existing = existingOpt.get();
            existing.setUsername(user.getUsername());
            existing.setPassword(user.getPassword());
            existing.setEmail(user.getEmail());
            existing.setRoles(user.getRoles()); // Works now with Set<String>
            return userRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}