package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entities.Course;
import com.example.springdatajpatutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Aman")
                .lastName("kumar")
                .courses(List.of(courseDBA, courseJava))
                .build();

        teacherRepository.save(teacher);
//        System.out.println(teacherRepository.findAll());
    }

    @Test
    void countTeacherByCourseIdNativeTest() {
        long count = teacherRepository.countTeacherByCourseIdNative(3L);
        System.out.println(count);
    }


}