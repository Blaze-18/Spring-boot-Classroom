package com.classroom.service;

import com.classroom.entity.Classroom;
import com.classroom.entity.Enrollment;
import com.classroom.entity.User;
import com.classroom.repository.ClassroomRepo;
import com.classroom.repository.EnrollmentRepo;
import com.classroom.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    // This service can be used to manage enrollments in courses or classes.
    // You can add methods to handle enrollment logic, such as enrolling a user in a course,
    // checking enrollment status, etc.

    private final EnrollmentRepo enrollmentRepo;
    private final ClassroomRepo classroomRepo;
    private final UserRepo userRepo;

    // Enroll a student in a classroom
    @Transactional
    public Enrollment enrollStudent(Long studentId, Long classroomId){
        if(enrollmentRepo.existsByStudentIdAndClassroomId(studentId, classroomId)){
            throw new RuntimeException("Student with id " + studentId + " is already enrolled in classroom with id " + classroomId);
        }

        User student = userRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student with id " + studentId + " not found"));

        Classroom classroom = classroomRepo.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom with id " + classroomId + " not found"));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .classroom(classroom)
                .enrolledAt(LocalDateTime.now())
                .build();

        return enrollmentRepo.save(enrollment);
    }
    // Get students in a classroom
    public List<User> getStudentsByClassroomId(Long classroomId) {
        return enrollmentRepo.findByClassroomId(classroomId)
                .stream()
                .map(Enrollment::getStudent)
                .collect(Collectors.toList());
    }

    // Get all classes for a student
    public List<Classroom> getClassroomsByStudentId(Long studentId) {
        return enrollmentRepo.findByStudentId(studentId)
                .stream()
                .map(Enrollment::getClassroom)
                .collect(Collectors.toList());
    }
}
