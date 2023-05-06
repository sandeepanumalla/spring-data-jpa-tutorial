package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String quardianName);
    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.guardian.email = ?1")
    Student findByGuardianEmail(String emailId);
    @Query(value = "select * from table_student s where s.email_address = ?1", nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailAddress);

    @Query(value = "select * from table_student s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNameParam(@Param("emailId") String emailAddress);

}
