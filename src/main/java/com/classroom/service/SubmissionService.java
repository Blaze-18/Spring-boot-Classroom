package com.classroom.service;

import com.classroom.entity.Assignment;
import com.classroom.entity.Submission;
import com.classroom.entity.User;
import com.classroom.repository.AssignmentRepo;
import com.classroom.repository.EnrollmentRepo;
import com.classroom.repository.SubmissionRepo;
import com.classroom.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SubmissionService {
    // This service will handle submission-related operations
    // such as creating, updating, and retrieving submissions.

    private final SubmissionRepo submissionRepo;
    private final AssignmentRepo assignmentRepo;
    private final UserRepo userRepo;

    public Submission submitAssignment(Long assignmentId, Long studentId, String submissionText) {
        // Validate the assignment and student
        if(submissionRepo.findByStudentIdAndAssignmentId(studentId, assignmentId).isPresent()){
            throw new RuntimeException( "Submission already exists for student with id " + studentId + " and assignment with id " + assignmentId);
        }
        Assignment assignment = assignmentRepo.findById(assignmentId).
                orElseThrow(() -> new RuntimeException("Assignment with id " + assignmentId + " not found"));
        User student = userRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student with id " + studentId + " not found"));

        Submission submission = Submission.builder()
                .assignment(assignment)
                .student(student)
                .submissionText(submissionText)
                .submittedAt(LocalDateTime.now())
                .build();

        return submissionRepo.save(submission);
    }
}
