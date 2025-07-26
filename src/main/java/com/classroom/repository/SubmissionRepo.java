package com.classroom.repository;

import com.classroom.entity.Submission;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubmissionRepo extends JpaRepository<Submission,Integer> {

    // This interface will handle CRUD operations for Submission entities.
    // It extends JpaRepository, which provides methods for basic CRUD operations.
    // Additional custom query methods can be defined here as needed.

    // Example custom query methods can be added here if needed.
    // For instance, you might want to find submissions by assignment ID or student ID.

    List<Submission> findByStudentId(Long studentId);
    List<Submission> findByAssignmentId(Long assignmentId);
    Optional<Submission> findByStudentIdAndAssignmentId(Long StudentId, Long AssignmentId);

    //Add more custom query methods as needed for your application.
}
