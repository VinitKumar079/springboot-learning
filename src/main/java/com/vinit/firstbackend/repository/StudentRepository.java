package com.vinit.firstbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinit.firstbackend.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);

    List<Student> findStudentsByCourse(String course);
    @Query("SELECT s FROM Student s WHERE s.course = :course")
List<Student> findStudentsByCourse1(
        @Param("course") String course);

    @Query(
    value = "SELECT * FROM student WHERE name = :name",
    nativeQuery = true
)
List<Student> findStudentNative(
        @Param("name") String name);
}

