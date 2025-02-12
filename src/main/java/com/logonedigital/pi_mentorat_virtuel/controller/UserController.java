package com.logonedigital.pi_mentorat_virtuel.controller;

import com.logonedigital.pi_mentorat_virtuel.entities.User;
import com.logonedigital.pi_mentorat_virtuel.services.sujet.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "user/add")
    ResponseEntity<User> addUser(@RequestBody User user){
        return ResponseEntity.status(201).body(this.userService.addUser(user));
    }

    @GetMapping(path = "User/getAll")
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.status(201).body(this.userService.getAllUser());
    }

    @GetMapping(path = "User/getbyId{userId}")
    public ResponseEntity<User> getbyId(@PathVariable Integer userId){
        return ResponseEntity.status(201).body(this.userService.getUserById(userId));
    }

    @PutMapping(path = "User/update{userId}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer userId){
        return ResponseEntity.status(201).body(this.userService.updatedUser(user, userId));
    }

    @DeleteMapping(path = "User/delete{userId}")
    public ResponseEntity<String> delete(@PathVariable Integer userId){
        this.userService.deleteUser(userId);

        return ResponseEntity.status(202).body("Delete Successfully !!");
    }
}
