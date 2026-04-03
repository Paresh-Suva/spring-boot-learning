package com.example.jpademo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    // SPRING CREATES THIS CONTROLLER AND INJECTS REPOSITORY OBJECT HERE.
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/save")
    public String save() {
        Student student = new Student();
        student.setName("Alice");
        student.setAge(20);

        studentRepository.save(student);

        return "STUDENT SAVED";
    }

    @GetMapping("/all")
    public List<Student> all() {
        // THIS LINE CALLS THE FIND ALL METHOD FROM THE REPOSITORY.
        return studentRepository.findAll();
    }
}

