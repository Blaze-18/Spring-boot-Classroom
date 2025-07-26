package com.classroom.service;

import com.classroom.entity.User;
import com.classroom.repository.AssignmentRepo;
import com.classroom.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    //register New User with encoded password

    public User registerUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    // Update existing user details
    public Optional<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public List<User> getUserByRole(User.Role role){
        return userRepo.findByRole(role);
    }
}
