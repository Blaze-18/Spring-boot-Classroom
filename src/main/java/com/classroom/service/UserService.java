package com.classroom.service;

import com.classroom.entity.User;
import com.classroom.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.spi.ToolProvider.findFirst;

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
    public List<User> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public List<User> getUserByRole(User.Role role){
        return userRepo.findByRole(role);
    }
    public List <User> getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public boolean checkPassword(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }
}
