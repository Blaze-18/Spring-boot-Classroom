package com.classroom.repository;

import com.classroom.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Long> {
    // This interface will handle CRUD operations for Assignment entities.
    // It extends JpaRepository, which provides methods for basic CRUD operations.
    // Additional custom query methods can be defined here as needed.
    //For instance, you might want to find assignments by classroom ID or title.

    List<Assignment> findByClassroomId(Long classroomId);
    List<Assignment> findByTitleContainingIgnoreCase(String title);

    // Add more custom query methods as needed for your application.
}
