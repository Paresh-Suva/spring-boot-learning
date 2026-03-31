package com.example.jpademo;

import org.springframework.data.jpa.repository.JpaRepository;

// THIS INTERFACE IS A REPOSITORY FOR STUDENT TABLE.
// JPA REPOSITORY PROVIDES BASIC DATABASE METHODS FOR US.
public interface StudentRepository extends JpaRepository<Student, Long> {
}

