package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public List<UserDTO> readAll() {
        return userService.readAllUsers().stream().map(UserDTO::new).toList();
    }

    public UserDTO getUserByID(Integer id){
        return new UserDTO(userService.getUserByID(id));
    }

    public UserDTO addUser(User user) {
        return new UserDTO(userService.addUser(user));
    }
}
