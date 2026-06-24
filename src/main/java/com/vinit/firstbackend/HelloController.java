package com.vinit.firstbackend;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HelloController {

    ArrayList<Student> studentsList = new ArrayList<>();

    // @GetMapping("/hello")
    // public String hello() {
    // return "Hello Vinit";
    // }

    // @GetMapping("/student")
    // public Student student() {
    // return new Student("Vinit", "Spring Boot");
    // }

    // @GetMapping("/hello/{name}")
    // public String sayHello(@PathVariable String name) {
    // return "Hello " + name;
    // }

    // @GetMapping("/college/{collegeName}")
    // public String college(@PathVariable String collegeName) {
    // return "My college is " + collegeName;
    // }

    // @GetMapping("/add")
    // public int add(
    // @RequestParam int a,
    // @RequestParam int b) {
    // return a + b;
    // }

    // @GetMapping("/multiply")
    // public int multiply(
    // @RequestParam int a,
    // @RequestParam int b) {
    // return a * b;
    // }

    // @PostMapping("/student") 
    // public Student createStudent(@RequestBody Student student) {
    // return student;
    // }

    // @GetMapping("/students")
    // public ArrayList<Student> students() {
    // ArrayList<Student> studentsList = new ArrayList<>();
    // studentsList.add(new Student("Vinit", "Spring Boot"));
    // studentsList.add(new Student("Alice", "Java"));
    // studentsList.add(new Student("Bob", "Python"));
    // return studentsList;
    // }

    @GetMapping("/load")
    public String loadData() {

        studentsList.add(new Student("Vinit", "Spring Boot"));
        studentsList.add(new Student("Rahul", "Java"));
        studentsList.add(new Student("Aman", "React"));
        studentsList.add(new Student("Rohit", "Python"));

        return "Students Loaded";
    }

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentsList;
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {

        studentsList.add(student);

        return "Student Added Successfully";
    }
}
