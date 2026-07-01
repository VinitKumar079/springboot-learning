package com.vinit.firstbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinit.firstbackend.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}