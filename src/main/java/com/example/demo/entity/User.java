package com.example.demo.entity;

import java.time.LocalDateTime;

public class User {
   
    private Long id;
    (unique = true)
    private String email;
    private String password;
    private String roles;
    private LocalDateTime createdAt;
    public User(){}
    public User(int id, String name,String email, String course, int age){
        this.id = id;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this. = ;
    }
}
