package com.example.jpademo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// THIS CLASS IS A DATABASE TABLE MODEL (ENTITY).
// @Entity TELLS JPA THIS CLASS MAPS TO A TABLE.
@Entity
public class Student {

    // @Id TURNS THIS FIELD INTO THE PRIMARY KEY.
    // @GeneratedValue TELLS DATABASE TO CREATE ID VALUE.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // THIS FIELD STORES STUDENT NAME.
    private String name;

    // THIS FIELD STORES STUDENT AGE.
    private int age;

    // THIS IS A DEFAULT CONSTRUCTOR.
    // JPA NEEDS IT TO CREATE OBJECTS.
    public Student() {
    }

    // THIS CONSTRUCTOR HELPS CREATE OBJECTS IN CONTROLLER.
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    // THIS METHOD RETURNS AGE.
    public int getAge() {
        return age;
    }

    // THIS METHOD SETS AGE.
    public void setAge(int age) {
        this.age = age;
    }
}

