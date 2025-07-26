package com.classroom.repository;

import com.classroom.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom, Long> {
    // This interface will handle CRUD operations for Classroom entities.
    // It extends JpaRepository, which provides methods for basic CRUD operations.
    // Additional custom query methods can be defined here as needed.
    List<Classroom> findByTeacherId(Long teacherId);
    List<Classroom> findByTitleContainingIgnoreCase(String title);
    List<Classroom> findBySubjectContainingIgnoreCase(String subject);

    // Add more custom query methods as needed for your application.
}
