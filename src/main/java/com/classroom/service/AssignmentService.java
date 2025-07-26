package com.classroom.service;

import com.classroom.entity.Assignment;
import com.classroom.entity.Classroom;
import com.classroom.repository.AssignmentRepo;
import com.classroom.repository.ClassroomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    // Service class for managing assignments in a classroom
    // This class handles operations related to assignments such as creating, retrieving, and deleting assignments.
    // It uses repositories to interact with the database.
    //
    private final AssignmentRepo assignmentRepo;
    private final ClassroomRepo classroomRepo;

    //Create a new assignment inside a classroom

    public Assignment createAssignment(Long classroomId, Assignment assignment) {
        Classroom classroom = classroomRepo.findById(classroomId)
                .orElseThrow(() -> new RuntimeException("Classroom with" + classroomId + " Not Found"));

        assignment.setClassroom(classroom);
        return assignmentRepo.save(assignment);

    }

    public List<Assignment> getAssignmentsByClassroom(Long classroomId) {
        return assignmentRepo.findByClassroomId(classroomId);
    }

    public List<Assignment> getAssignmentsByTitle(String title) {
        return assignmentRepo.findByTitleContainingIgnoreCase(title);
    }

    public void deleteAssignment(Long assignmentId) {
        assignmentRepo.deleteById(assignmentId);
    }
}
