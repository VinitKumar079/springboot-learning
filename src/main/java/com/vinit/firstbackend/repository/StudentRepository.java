package com.vinit.firstbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinit.firstbackend.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);
}
