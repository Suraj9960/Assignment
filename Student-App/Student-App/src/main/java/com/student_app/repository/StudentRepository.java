package com.student_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student_app.entities.Student;



public interface StudentRepository extends JpaRepository<Student, Integer> {

}
