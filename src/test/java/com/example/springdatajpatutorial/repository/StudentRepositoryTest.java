package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entities.Guardian;
import com.example.springdatajpatutorial.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("sandeep@gmail.com")
                .firstName("sandeep")
                .lastName("anumalla")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("nikhil")
                .mobile("2342494513")
                .build();
        Student student = Student.builder()
                .firstName("shivam")
                .emailId("shivam@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> listOfStudents = studentRepository.findAll();
        System.out.println(listOfStudents);
    }

    @Test
    public void printStudentById() {
        Optional<Student> listOfStudents = studentRepository.findById(1L);
        System.out.println(listOfStudents.isPresent() ? listOfStudents : "");
    }

    @Test
    void testFindByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("sandeep");
        System.out.println(studentList);
    }

    @Test
    void testFindByFirstNameContaining(){
        List<Student> listOfStudents = studentRepository.findByFirstNameContaining("sh");
        System.out.println(listOfStudents);
    }

    @Test
    void testFindByGuardianName() {
       List<Student> listOfStudents = studentRepository.findByGuardianName("nikhil");
        System.out.println(listOfStudents);
    }

    @Test
    void testFindByFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("nikhil", "kumar");
        System.out.println(student);
    }

    @Test
    void testFindByLastNameNotNull() {
        List<Student> listOfStudents = studentRepository.findByLastNameNotNull();
        System.out.println(listOfStudents);
    }

    @Test
    void testFindByByGuardianEmail() {
        Student student = studentRepository.findByGuardianEmail("mom@gmail.com");
        System.out.println(student);
    }

    @Test
    void getFirstNameByEmailAddressNative( ) {
        Student student = studentRepository.getStudentByEmailAddressNative("sandeep@gmail.com");
        System.out.println(student);
    }

    @Test
    void getStudentByEmailAddressNativeNameParam( ) {
        Student student = studentRepository.getStudentByEmailAddressNativeNameParam("sandeep@gmail.com");
        System.out.println(student);
    }
}