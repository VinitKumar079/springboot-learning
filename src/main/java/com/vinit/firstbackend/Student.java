package com.vinit.firstbackend;

public class Student {

    private String name;
    private String course;
    private int age;
    private String college;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
        this.age = 20; // Default age, you can modify this as needed
        this.college = "IPEC"; // Default college, you can modify this as needed
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
    public int getAge() {
        return age;
    }

    public String getCollege() {
        return college;
    }
}