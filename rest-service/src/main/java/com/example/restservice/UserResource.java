package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserResource.USERS)
public class UserResource {
    public static final String USERS = "/v0/users";
    @Autowired
    UserController userController;

    @GetMapping
    public ResponseEntity<List<UserDTO>> users() {
        return new ResponseEntity<>(userController.readAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> user(@PathVariable Integer id){
        return new ResponseEntity<>(userController.getUserByID(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> newUser(@RequestBody User user){
       return ResponseEntity.ok(userController.addUser(user));
    }
}
