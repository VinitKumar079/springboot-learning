package com.vinit.firstbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vinit.firstbackend.Course;

public interface CourseRepository
        extends JpaRepository<Course, Integer> {

}