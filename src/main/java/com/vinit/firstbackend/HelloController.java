package com.vinit.firstbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}