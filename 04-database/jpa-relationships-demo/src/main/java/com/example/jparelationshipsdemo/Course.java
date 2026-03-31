package com.example.jparelationshipsdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

// THIS CLASS IS A DATABASE TABLE MODEL (ENTITY).
// @Entity TELLS JPA THIS CLASS MAPS TO A TABLE.
@Entity
public class Course {

    // THIS FIELD BECOMES THE PRIMARY KEY.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // THIS FIELD STORES COURSE TITLE.
    private String title;

    // THIS RELATIONSHIP MEANS MANY COURSES BELONG TO ONE STUDENT.
    // MANY TO ONE TELLS JPA THIS COURSE HAS ONE STUDENT.
    // JOINT COLUMN TELLS DATABASE THE FOREIGN KEY COLUMN NAME.
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // THIS IS A DEFAULT CONSTRUCTOR.
    // JPA NEEDS IT TO CREATE OBJECTS.
    public Course() {
    }

    // THIS CONSTRUCTOR HELPS CREATE OBJECTS IN CONTROLLER.
    public Course(String title) {
        this.title = title;
    }

    // THIS METHOD RETURNS ID.
    public Long getId() {
        return id;
    }

    // THIS METHOD SETS ID.
    public void setId(Long id) {
        this.id = id;
    }

    // THIS METHOD RETURNS TITLE.
    public String getTitle() {
        return title;
    }

    // THIS METHOD SETS TITLE.
    public void setTitle(String title) {
        this.title = title;
    }

    // THIS METHOD RETURNS STUDENT.
    public Student getStudent() {
        return student;
    }

    // THIS METHOD SETS STUDENT.
    public void setStudent(Student student) {
        this.student = student;
    }
}

