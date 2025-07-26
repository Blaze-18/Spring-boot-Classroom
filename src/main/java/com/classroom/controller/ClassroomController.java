package com.classroom.controller;

import com.classroom.entity.Classroom;
import com.classroom.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/create")
    public Classroom createClassroom(@RequestBody Classroom classroom, @RequestParam Long teacherId) {
        return classroomService.createClassroom(classroom, teacherId);
    }

    @GetMapping("/all")
    public List<Classroom> getAllClassroom() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("by-teacher/{teacherId}")
    public List<Classroom> getClassroomsByTeacher(@PathVariable Long teacherId) {
        return classroomService.getClassroomsByTeacher(teacherId);
    }
}
