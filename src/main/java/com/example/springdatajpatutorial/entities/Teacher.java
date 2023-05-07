package com.example.springdatajpatutorial.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private Long teacherId;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    @ToString.Exclude
    private List<Course> courses;
}
