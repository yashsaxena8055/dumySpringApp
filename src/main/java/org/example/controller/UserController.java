package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

     @Autowired
     private UserService service;

@GetMapping
    public List<User> getAllUser(){
    System.out.println(service.getAllUsers());
    return service.getAllUsers();
  }


//  @PostMapping
//    public User getUser(){
//
//  }

}



