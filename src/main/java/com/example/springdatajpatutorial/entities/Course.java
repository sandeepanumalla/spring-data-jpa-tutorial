package com.example.springdatajpatutorial.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_course_map",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
            ,inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    )
//    @ToString.Exclude
    private List<Student> students;
    public void addStudent(Student student) {
        if(students == null) students = new ArrayList<>();
        students.add(student);
    }
}
