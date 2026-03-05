package com.school.student_api.repository;

import com.school.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Check if a student with this email already exists
    boolean existsByEmail(String email);
}