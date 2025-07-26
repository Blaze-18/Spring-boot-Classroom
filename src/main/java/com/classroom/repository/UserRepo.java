package com.classroom.repository;

import com.classroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    // This class will contain methods to interact with the User entity in the database.
    // It will typically extend JpaRepository or CrudRepository to provide basic CRUD operations.
    // Additional custom methods can be defined here as needed.

    Optional<User> findByEmail(String email);
    List<User> findByRole(User.Role role);
    List<User> findByNameContainingIgnoreCase(String name);

    // Add more custom query methods as needed for your application.
}
