package com.example.jparelationshipsdemo;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository PROVIDES DATABASE METHODS LIKE save() AND findAll().
public interface StudentRepository extends JpaRepository<Student, Long> {
}

