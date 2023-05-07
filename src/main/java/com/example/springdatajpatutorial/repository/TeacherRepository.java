package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
//    @Query( value = "SELECT COUNT(DISTINCT t.teacher_id) FROM teacher t JOIN course c ON " +
//            "t.teacher_id = c.teacher_id" +
//            "WHERE c.course_id = :courseId", nativeQuery = true)

    @Query(value = "SELECT COUNT(DISTINCT teacher.teacher_id) " +
            "FROM teacher " +
            "JOIN course ON teacher.teacher_id = course.teacher_id " +
            "WHERE course.course_id = :courseId", nativeQuery = true)
    long countTeacherByCourseIdNative(@Param("courseId") Long courseId);
}
