package com.vinit.firstbackend.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinit.firstbackend.Student;
import com.vinit.firstbackend.Exception.StudentNotFoundException;
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

    return studentRepository.findById(id)
            .orElseThrow(() ->
                    new StudentNotFoundException("Student Not Found"));
}

    public String deleteStudent(int id) {

        studentRepository.deleteById(id);

        return "Student Deleted Successfully";
    }

    public String updateStudent(int id, Student updatedStudent){
        
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student existingStudent = studentOptional.get();
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setId(updatedStudent.getId());
            existingStudent.setEmail(updatedStudent.getEmail());
            studentRepository.save(existingStudent);
            return "Student Updated Successfully";
        } else {
            return "Student Not Found";
        }
    }
}