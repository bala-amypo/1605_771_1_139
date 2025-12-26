package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.University;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/users")
public class UserController {


private final UserService userService;


public UserController(UserService userService) {
this.userService = userService;
}


@PostMapping("/register")
public ResponseEntity<User> register(@RequestBody User user) {
return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
}


@GetMapping("/{email}")
public ResponseEntity<User> getByEmail(@PathVariable String email) {
return ResponseEntity.ok(userService.findByEmail(email));
}
}