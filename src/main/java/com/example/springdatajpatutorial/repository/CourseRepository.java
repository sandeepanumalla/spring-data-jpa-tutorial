package com.example.springdatajpatutorial.repository;

import com.example.springdatajpatutorial.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    long countDistintByTeacherTeacherId(Long teacherId);
}
