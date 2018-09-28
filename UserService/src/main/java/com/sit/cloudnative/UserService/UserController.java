package com.sit.cloudnative.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllPostList() {
        List<User> user = userService.getAllUser();
        return new ResponseEntity<List<User>>(user, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getAllPostList(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<Long>(id,HttpStatus.OK);
    }
}
