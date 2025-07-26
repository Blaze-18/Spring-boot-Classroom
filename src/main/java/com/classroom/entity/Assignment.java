package com.classroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary Key

    private String title;

    private String description;

    private LocalDateTime dueDate; // Due date for the assignment

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom; // The classroom to which this assignment belongs

    @OneToMany(mappedBy = "assignment")
    private List<Submission> submissions; // List of submissions for this assignment
}
