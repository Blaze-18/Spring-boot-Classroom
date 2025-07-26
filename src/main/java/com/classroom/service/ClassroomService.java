package com.classroom.service;

import com.classroom.entity.Classroom;
import com.classroom.entity.User;
import com.classroom.repository.ClassroomRepo;
import com.classroom.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepo classroomRepo;
    private final UserRepo userRepo;

    //Create a new Classroom
    public Classroom createClassroom(Classroom classroom, Long teacherId) {
        User teacher = userRepo.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher with id " + teacherId + " was id not found"));

        if(teacher.getRole() != User.Role.TEACHER){
            throw new RuntimeException("Only Users with the role TEACHER can create a Classroom");
        }

        classroom.setTeacher(teacher);
        return classroomRepo.save(classroom);
    }

    /**
     * Retrieves all classrooms created by a specific teacher.
     * @param teacherId the ID of the teacher
     * @return list of classrooms associated with the teacher
     */
    public List<Classroom> getClassroomsByTeacher(Long teacherId) {
        return classroomRepo.findByTeacherId(teacherId);
    }

    /**
     * Retrieves all classrooms in the system.
     * @return list of all classrooms
     */
    public List<Classroom> getAllClassrooms() {
        return classroomRepo.findAll();
    }

    /**
     * Deletes a classroom by its ID if it exists.
     * @param classroomId the ID of the classroom to delete
     * @throws RuntimeException if the classroom is not found
     */
    public void deleteClassroom(Long classroomId) {
        if (!classroomRepo.existsById(classroomId)) {
            throw new RuntimeException("Classroom with id " + classroomId + " was not found");
        }
        classroomRepo.deleteById(classroomId);
    }

}
