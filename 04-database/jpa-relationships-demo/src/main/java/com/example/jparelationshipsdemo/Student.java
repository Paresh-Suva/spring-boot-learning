package com.example.jparelationshipsdemo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// THIS CLASS IS A DATABASE TABLE MODEL (ENTITY).
// @Entity TELLS JPA THIS CLASS MAPS TO A TABLE.
@Entity
public class Student {

    // THIS FIELD BECOMES THE PRIMARY KEY.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // THIS FIELD STORES STUDENT NAME.
    private String name;

    // THIS RELATIONSHIP MEANS ONE STUDENT HAS MANY COURSES.
    // MAPPEDBY TELLS JPA WHICH SIDE STORES THE FOREIGN KEY.
    // CASCADE = ALL MEANS SAVING STUDENT WILL ALSO SAVE COURSES.
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    // THIS IS A DEFAULT CONSTRUCTOR.
    // JPA NEEDS IT TO CREATE OBJECTS.
    public Student() {
    }

    // THIS CONSTRUCTOR HELPS CREATE OBJECTS IN CONTROLLER.
    public Student(String name) {
        this.name = name;
    }

    // THIS METHOD RETURNS ID.
    public Long getId() {
        return id;
    }

    // THIS METHOD SETS ID.
    public void setId(Long id) {
        this.id = id;
    }

    // THIS METHOD RETURNS NAME.
    public String getName() {
        return name;
    }

    // THIS METHOD SETS NAME.
    public void setName(String name) {
        this.name = name;
    }

    // THIS METHOD RETURNS THE COURSE LIST.
    public List<Course> getCourses() {
        return courses;
    }
}

