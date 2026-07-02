package com.vinit.firstbackend.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinit.firstbackend.Student;
import com.vinit.firstbackend.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student) {

        studentRepository.save(student);

        return "Student Saved In Database";
    }

    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    public String deleteStudent(int id) {

        studentRepository.deleteById(id);

        return "Student Deleted Successfully";
    }
}