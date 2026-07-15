package com.vinit.firstbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinit.firstbackend.dto.StudentDTO;
import com.vinit.firstbackend.response.ApiResponse;
import com.vinit.firstbackend.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class HelloController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    public String createStudent(
            @Valid @RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<ApiResponse> getStudentById(
            @PathVariable int id) {

        Student student =
                studentService.getStudentById(id);

        ApiResponse response =
                new ApiResponse(
                        true,
                        "Student fetched successfully",
                        student);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(
            @PathVariable int id) {

        return studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody Student updatedStudent) {

        String response =
                studentService.updateStudent(
                        id,
                        updatedStudent);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/students/name/{name}")
    public List<Student> getStudentsByName(
            @PathVariable String name) {

        return studentService.getStudentByName(name);
    }

    @GetMapping("/students/page")
    public Page<Student> getStudentsPage(
            @RequestParam int page,
            @RequestParam int size) {

        return studentService.getStudentsPage(
                page,
                size);
    }

    @GetMapping("/students/sort")
    public List<Student> getStudentsSorted() {

        return studentService.getStudentsSorted();
    }

    @GetMapping("/students/course/{course}")
    public List<Student> getStudentsByCourse(
            @PathVariable String course) {

        return studentService.getStudentsByCourse(
                course);
    }

    @GetMapping("/students/dto")
    public List<StudentDTO> getStudentDTOs() {

        return studentService.getStudentDTOs();
    }
}