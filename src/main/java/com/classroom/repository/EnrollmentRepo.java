package com.classroom.repository;

import com.classroom.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment,Integer> {

    // This interface will handle CRUD operations for Enrollment entities.
    // It extends JpaRepository, which provides methods for basic CRUD operations.
    // Additional custom query methods can be defined here as needed.

    List<Enrollment> findByStudentId(Long studentId); // all enrollments by student
    List<Enrollment> findByClassroomId(Long classroomId); // all students in a class
    boolean existsByStudentIdAndClassroomId(Long studentId, Long classroomId); // prevent duplicate enrollment

    // Add more custom query methods as needed for your application.

}
