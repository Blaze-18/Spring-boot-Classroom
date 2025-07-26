package com.classroom.controller;


import com.classroom.entity.User;
import com.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.registerUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        User user = (User) userService.getUserByEmail(email);
        if(user != null && userService.checkPassword(user, password)) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized
        }
    }
}
