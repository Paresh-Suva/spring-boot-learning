package com.example.jparelationshipsdemo;

import org.springframework.data.jpa.repository.JpaRepository;

// THIS INTERFACE IS A REPOSITORY FOR Student TABLE.
// JpaRepository PROVIDES DATABASE METHODS LIKE save() AND findAll().
public interface StudentRepository extends JpaRepository<Student, Long> {
}

