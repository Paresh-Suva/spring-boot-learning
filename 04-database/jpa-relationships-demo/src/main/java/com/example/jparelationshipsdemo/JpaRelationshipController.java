package com.example.jparelationshipsdemo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// THIS CLASS HANDLES THE /TEST ENDPOINT.
// @RESTCONTROLLER TELLS SPRING TO RETURN DATA DIRECTLY.
@RestController
public class JpaRelationshipController {

    // THIS VARIABLE HOLDS THE STUDENT REPOSITORY OBJECT.
    private final StudentRepository studentRepository;

    // SPRING CREATES THIS CONTROLLER AND INJECTS REPOSITORY HERE.
    public JpaRelationshipController(StudentRepository studentRepository) {
        // THIS LINE SAVES REPOSITORY OBJECT FOR LATER USE.
        this.studentRepository = studentRepository;
    }

    // @GETMAPPING TELLS SPRING THIS METHOD RUNS FOR /TEST.
    // THIS METHOD CREATES ONE STUDENT WITH COURSES AND SAVES IT.
    @GetMapping("/test")
    public String test() {
        // THIS LINE CREATES STUDENT OBJECT (NOT YET IN DATABASE).
        Student student = new Student();
        // THIS LINE SETS STUDENT NAME.
        student.setName("Tom");

        // THIS LINE CREATES COURSE OBJECT 1.
        Course math = new Course();
        // THIS LINE SETS COURSE TITLE.
        math.setTitle("Math");
        // THIS LINE LINKS COURSE TO STUDENT (SETS STUDENT FIELD).
        math.setStudent(student);

        // THIS LINE CREATES COURSE OBJECT 2.
        Course science = new Course();
        // THIS LINE SETS COURSE TITLE.
        science.setTitle("Science");
        // THIS LINE LINKS COURSE TO STUDENT.
        science.setStudent(student);

        // THIS LINE ADDS BOTH COURSES INTO COURSES LIST.
        student.getCourses().add(math);
        student.getCourses().add(science);

        // THIS LINE SAVES STUDENT AND COURSES (CASCADE = ALL).
        Student saved = studentRepository.save(student);

        // THIS LINE READS SAVED COURSES COUNT.
        int count = saved.getCourses().size();

        // THIS LINE BUILDS RESPONSE STRING.
        return "STUDENT SAVED WITH " + count + " COURSES";
    }
}

