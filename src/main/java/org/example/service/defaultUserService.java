package org.example.service;

import org.example.model.User;
import org.example.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class defaultUserService implements UserService {


    @Autowired
    private UserDB repository;

    public defaultUserService() {
    }

    public void setRepository(UserDB repository) {

        this.repository = repository;
    }


    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }


    @Override
    public void addUsers(User user) {
        repository.save(user);
    }


}
