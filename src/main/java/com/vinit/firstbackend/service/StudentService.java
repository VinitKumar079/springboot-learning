package com.vinit.firstbackend.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.vinit.firstbackend.Student;
import org.springframework.beans.factory.annotation.Autowired;
import com.vinit.firstbackend.service.StudentService;

@Service
public class StudentService {
    ArrayList<Student> studentsList = new ArrayList<>();
    public String loadData(){
         studentsList.add(new Student("Vinit", "Spring Boot"));
         studentsList.add(new Student("John", "Java"));
         studentsList.add(new Student("Alice", "Python"));
         return "Data loaded successfully";
    }
    public ArrayList<Student> getStudents() {
        return studentsList;
    }
    public String createStudent(Student student) {
        studentsList.add(student);
        return "Student created successfully";
    }
    public String updateStudent(int index, Student updatedStudent){
        studentsList.set(index, updatedStudent);
        return "Student updated successfully";
    }
    public String deleteStudent(int index){
        studentsList.remove(index);
        return "Student deleted successfully";
    }
}
