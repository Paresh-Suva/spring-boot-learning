package com.example.jpademo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS IS A REST CONTROLLER FOR DATABASE DEMO.
// @RESTCONTROLLER TELLS SPRING TO RETURN DATA DIRECTLY.
@RestController
public class StudentController {

    // THIS VARIABLE HOLDS THE STUDENT REPOSITORY OBJECT.
    private final StudentRepository studentRepository;

    // SPRING CREATES THIS CONTROLLER AND INJECTS REPOSITORY OBJECT HERE.
    public StudentController(StudentRepository studentRepository) {
        // THIS LINE SAVES REPOSITORY OBJECT IN THIS CONTROLLER.
        this.studentRepository = studentRepository;
    }

    // @GETMAPPING TELLS SPRING TO RUN THIS METHOD FOR /SAVE.
    // THIS METHOD CREATES ONE HARDCODED STUDENT AND SAVES IT.
    @GetMapping("/save")
    public String save() {
        // THIS LINE CREATES NEW STUDENT OBJECT IN MEMORY.
        Student student = new Student();
        // THIS LINE SETS NAME FIELD.
        student.setName("Alice");
        // THIS LINE SETS AGE FIELD.
        student.setAge(20);

        // THIS LINE SAVES STUDENT INTO DATABASE (H2).
        studentRepository.save(student);

        // THIS LINE RETURNS SIMPLE CONFIRMATION STRING.
        return "STUDENT SAVED";
    }

    // @GETMAPPING TELLS SPRING TO RUN THIS METHOD FOR /ALL.
    // THIS METHOD RETURNS ALL STUDENTS FROM DATABASE AS JSON.
    @GetMapping("/all")
    public List<Student> all() {
        // THIS LINE CALLS THE FIND ALL METHOD FROM THE REPOSITORY.
        return studentRepository.findAll();
    }
}

