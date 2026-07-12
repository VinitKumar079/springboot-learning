package com.vinit.firstbackend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Course cannot be empty")
    private String course;

    public Student() {

    }

    public Student(String name, String course) {

        this.name = name;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // public Object getEmail() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    // }

    // public void setEmail(Object email) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
    // }

    @OneToMany(
        mappedBy = "student",
        cascade = CascadeType.ALL)
private List<Course> courses;
    public List<Course> getCourses() {
    return courses;
}

public void setCourses(
        List<Course> courses) {
    this.courses = courses;
}   
}