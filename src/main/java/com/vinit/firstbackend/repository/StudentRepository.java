package com.vinit.firstbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vinit.firstbackend.Student;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {

    List<Student> findByName(String name);

    @Query("SELECT s FROM Student s WHERE s.course = :course")
    List<Student> findStudentsByCourse(
            @Param("course") String course);

    @Query(
            value = "SELECT * FROM student WHERE name = :name",
            nativeQuery = true)
    List<Student> findStudentNative(
            @Param("name") String name);
}