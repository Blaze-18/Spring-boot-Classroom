package com.classroom.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "classrooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary Key

    @Column(nullable = false)
    private String title;

    private String Description;

    private String subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;

    @OneToMany(mappedBy = "classroom")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "classroom")
    private List<Assignment> assignments;


}
