package com.vinit.firstbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Vinit";
    }

    @GetMapping("/student")
    public Student student() {
        return new Student("Vinit", "Spring Boot");
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/college/{collegeName}")
    public String college(@PathVariable String collegeName) {
        return "My college is " + collegeName;
    }

    @GetMapping("/add")
    public int add(
            @RequestParam int a,
            @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/multiply")
    public int multiply(
            @RequestParam int a,
            @RequestParam int b) {
        return a * b;
    }

}