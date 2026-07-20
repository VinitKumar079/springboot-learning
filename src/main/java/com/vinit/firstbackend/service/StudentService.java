package com.vinit.firstbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinit.firstbackend.Course;
import com.vinit.firstbackend.Student;
import com.vinit.firstbackend.Exception.StudentNotFoundException;
import com.vinit.firstbackend.repository.StudentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.vinit.firstbackend.dto.StudentDTO;

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

    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Student Deleted Successfully";
    }

    public String updateStudent(int id, Student updatedStudent) {

        Optional<Student> studentOptional =
                studentRepository.findById(id);

        if (studentOptional.isPresent()) {

            Student existingStudent =
                    studentOptional.get();

            existingStudent.setName(
                    updatedStudent.getName());

            existingStudent.setCourse(
                    updatedStudent.getCourse());

            studentRepository.save(existingStudent);

            return "Student Updated Successfully";
        }

        return "Student Not Found";
    }

    public Page<Student> getStudentsPage(
            int page,
            int size) {

        Pageable pageable =
                PageRequest.of(page, size);

        return studentRepository.findAll(pageable);
    }

    public List<Student> getStudentsSorted() {

        return studentRepository.findAll(
                Sort.by("name"));
    }

    public List<Student> getStudentsByCourse(
            String course) {

        return studentRepository
                .findStudentsByCourse(course);
    }
    public String createStudent1(Student student) {

    if (student.getCourses() != null) {
        for (Course course : student.getCourses()) {
            course.setStudent(student);
        }
    }

    studentRepository.save(student);

    return "Student Saved Successfully";
}
public List<StudentDTO> getStudentDTOs() {

    List<Student> students =
            studentRepository.findAll();

    return students.stream()
            .map(student ->
                    new StudentDTO(
                            student.getId(),
                            student.getName()))
            .toList();
}
public Student createSampleStudent() {

    return Student.builder()
            .name("Vinit")
            .course("Spring Boot")
            .build();
}   
}