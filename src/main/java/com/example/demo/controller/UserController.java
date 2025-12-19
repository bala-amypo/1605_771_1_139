package com.example.demo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;


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