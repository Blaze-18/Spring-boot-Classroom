package com.classroom.controller;

import com.classroom.entity.Assignment;
import com.classroom.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms/{classroomId}/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<Assignment> createAssignment(
            @PathVariable Long classroomId,
            @RequestBody Assignment assignment) {
        Assignment createdAssignment = assignmentService.createAssignment(classroomId, assignment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAssignment);
    }

    @GetMapping
    public ResponseEntity<List<Assignment>> getAssignmentsByClassroom(
            @PathVariable Long classroomId) {
        List<Assignment> assignments = assignmentService.getAssignmentsByClassroom(classroomId);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Assignment>> searchAssignmentsByTitle(
            @PathVariable Long classroomId,
            @RequestParam String title) {
        List<Assignment> assignments = assignmentService.getAssignmentsByTitle(title);
        return ResponseEntity.ok(assignments);
    }

    @DeleteMapping("/{assignmentId}")
    public ResponseEntity<Void> deleteAssignment(
            @PathVariable Long classroomId,
            @PathVariable Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
        return ResponseEntity.noContent().build();
    }
}