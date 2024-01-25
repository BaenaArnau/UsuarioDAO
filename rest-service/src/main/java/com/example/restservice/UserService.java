package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public List<User> readAllUsers() {
        return userDAO.findAll();
    }

    public User getUserByID(Integer id) {
        return userDAO.findById(id).orElse(null);
    }
}
