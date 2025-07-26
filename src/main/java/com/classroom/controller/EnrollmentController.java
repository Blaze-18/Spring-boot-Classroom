package com.classroom.controller;

import com.classroom.entity.Classroom;
import com.classroom.entity.Enrollment;
import com.classroom.entity.User;
import com.classroom.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollment")
public class EnrollmentController {
    
    @Autowired
    private EnrollmentService enrollmentService;
    
    @PostMapping("/enroll")
    public Enrollment enrollStudent(Long studentId, Long classroomId) {
        return enrollmentService.enrollStudent(studentId, classroomId);
    }
    
    @GetMapping("/students/{classroomId}")
    public List<User> getStudents(@PathVariable Long classroomId) {
        return enrollmentService.getStudentsByClassroomId(classroomId);
    }
    @GetMapping("/classrooms/{studentId}")
    public List<Classroom> getClasses(@PathVariable Long studentId) {
        return enrollmentService.getClassroomsByStudentId(studentId);
    }
}
