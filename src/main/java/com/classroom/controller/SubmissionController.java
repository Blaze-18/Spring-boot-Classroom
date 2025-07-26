package com.classroom.controller;

import com.classroom.entity.Submission;
import com.classroom.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments/{assignmentId}/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping
    public ResponseEntity<Submission> submitAssignment(
            @PathVariable Long assignmentId,
            @RequestParam Long studentId,
            @RequestBody String submissionText) {

        Submission submission = submissionService.submitAssignment(
                assignmentId,
                studentId,
                submissionText
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(submission);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleSubmissionExceptions(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
}