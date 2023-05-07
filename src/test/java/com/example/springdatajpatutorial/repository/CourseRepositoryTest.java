package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entities.Course;
import com.example.springdatajpatutorial.entities.Student;
import com.example.springdatajpatutorial.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void saveCourseWithTeacher() {
        Course course = Course.builder()
                .title("C Programming")
                .credit(9)
                .build();
    }

    @Test
    public void saveCourseWithTeacherAndStudent() {

//        Teacher teacher = Teacher.builder()
//                .firstName("Lizze")
//                .firstName("Mcdowel")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("sunny")
//                .lastName("kumar")
//                .emailId("sunny@gmail.com")
//                .build();
//
//        Course course = Course.builder()
//                .title("AI")
//                .credit(8)
//                .teacher(teacher)
//                .build();
//
//        course.addStudent(student);
//
//        courseRepository.save(course);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2,
                Sort.by("title").and(Sort.by("credit").descending()));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    void countCoursesByTeacherTeacherIdTest(){
        long count = courseRepository.countDistintByTeacherTeacherId(1L);
        System.out.println(count);
    }
}