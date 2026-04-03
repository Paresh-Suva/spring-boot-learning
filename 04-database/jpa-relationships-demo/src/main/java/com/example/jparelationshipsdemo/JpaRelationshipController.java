package com.example.jparelationshipsdemo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaRelationshipController {

    private final StudentRepository studentRepository;

    public JpaRelationshipController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/test")
    public String test() {
        Student student = new Student();
        student.setName("Tom");

        Course math = new Course();
        math.setTitle("Math");
        math.setStudent(student);

        Course science = new Course();
        science.setTitle("Science");
        science.setStudent(student);

        student.getCourses().add(math);
        student.getCourses().add(science);

        Student saved = studentRepository.save(student);
        int count = saved.getCourses().size();

        return "STUDENT SAVED WITH " + count + " COURSES";
    }
}

