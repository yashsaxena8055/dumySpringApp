package org.example.service;

import org.example.model.User;

import java.util.List;


public interface UserService  {

    public List<User> getAllUsers();


    void addUsers(User user);
}
