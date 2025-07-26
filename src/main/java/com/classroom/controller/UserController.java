package com.classroom.controller;

import com.classroom.entity.User;
import com.classroom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/by-role")
    public List<User> getUserByRole(@RequestParam User.Role role){
        return userService.getUserByRole(role);
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email)
                .stream()
                .findFirst()
                .orElse(null); // Return null if no user found with the given email
    }

}
