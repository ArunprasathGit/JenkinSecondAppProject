package com.ms.secondapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.secondapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
