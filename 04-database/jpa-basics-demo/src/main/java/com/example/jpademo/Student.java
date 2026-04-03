package com.example.jpademo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity : JPA THIS CLASS MAPS TO A TABLE
@Entity
public class Student {

    // @Id : THE PRIMARY KEY.
    // @GeneratedValue TELLS DATABASE TO CREATE ID VALUE.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    // THIS IS A DEFAULT CONSTRUCTOR JPA NEEDS IT TO CREATE OBJECTS.
    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

