package com.vinit.firstbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

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

}