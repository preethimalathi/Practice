package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // You can add custom queries here if needed.
}
