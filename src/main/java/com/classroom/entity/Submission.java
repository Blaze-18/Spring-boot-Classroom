package com.classroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary Key

    private String submissionText;

    private LocalDateTime submittedAt; // Date and time of submission

    private Double grade; // Grade for the submission, can be null if not graded yet

    private String feedback; // Feedback provided by the teacher, can be null if not provided

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student; // The student who made the submission

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment; // The assignment to which this submission belongs
}
