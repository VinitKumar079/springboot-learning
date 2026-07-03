// package com.vinit.firstbackend;

// import java.util.ArrayList;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.beans.factory.annotation.Autowired;

// import com.vinit.firstbackend.service.StudentService;

// @RestController
// public class HelloController {
//     @Autowired
//     StudentService studentService;

//     // ArrayList<Student> studentsList = new ArrayList<>();

//     // @GetMapping("/hello")
//     // public String hello() {
//     // return "Hello Vinit";
//     // }

//     // @GetMapping("/student")
//     // public Student student() {
//     // return new Student("Vinit", "Spring Boot");
//     // }

//     // @GetMapping("/hello/{name}")
//     // public String sayHello(@PathVariable String name) {
//     // return "Hello " + name;
//     // }

//     // @GetMapping("/college/{collegeName}")
//     // public String college(@PathVariable String collegeName) {
//     // return "My college is " + collegeName;
//     // }

//     // @GetMapping("/add")
//     // public int add(
//     // @RequestParam int a,
//     // @RequestParam int b) {
//     // return a + b;
//     // }

//     // @GetMapping("/multiply")
//     // public int multiply(
//     // @RequestParam int a,
//     // @RequestParam int b) {
//     // return a * b;
//     // }

//     // @PostMapping("/student")
//     // public Student createStudent(@RequestBody Student student) {
//     // return student;
//     // }

//     // @GetMapping("/students")
//     // public ArrayList<Student> students() {
//     // ArrayList<Student> studentsList = new ArrayList<>();
//     // studentsList.add(new Student("Vinit", "Spring Boot"));
//     // studentsList.add(new Student("Alice", "Java"));
//     // studentsList.add(new Student("Bob", "Python"));
//     // return studentsList;
//     // }

//     @GetMapping("/load")
//     public String loadData() {

//         // studentsList.add(new Student("Vinit", "Spring Boot"));
//         // studentsList.add(new Student("Rahul", "Java"));
//         // studentsList.add(new Student("Aman", "React"));
//         // studentsList.add(new Student("Rohit", "Python"));

//         return studentService.loadData();
//     }

//     @GetMapping("/students")
//     public ArrayList<Student> getStudents() {
//         return studentService.getStudents();
//     }

//     @PostMapping("/students")
//     public String createStudent(@RequestBody Student student) {

//         // studentsList.add(student);
//         return studentService.createStudent(student);
//         // return "Student Added Successfully";
//     }

//     @PutMapping("/students/{index}")
//     public String updateStudent(
//             @PathVariable int index,
//             @RequestBody Student updatedStudent) {

//         // studentsList.set(index, updatedStudent);

//         return studentService.updateStudent(index, updatedStudent);
//     }

//     @DeleteMapping("/students/{index}")
//     public String deleteStudent(@PathVariable int index) {

//         // studentsList.remove(index);
//         return studentService.deleteStudent(index); 
//         // return "Student Deleted Successfully";
//     }
// }

package com.vinit.firstbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;

import com.vinit.firstbackend.service.StudentService;

@RestController
public class HelloController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents() {

        return studentService.getStudents();
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        return studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        String response = studentService.updateStudent(id, updatedStudent);

        return ResponseEntity.ok(response);
    }
}