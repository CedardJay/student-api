package com.school.student_api.service;

import com.school.student_api.model.Student;
import com.school.student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Manual constructor injection (replaces @RequiredArgsConstructor)
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET single student by id
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // CREATE a new student
    public Student createStudent(Student student) {
        if (studentRepository.existsByEmail(student.getEmail())) {
            throw new RuntimeException("Email already exists: " + student.getEmail());
        }
        return studentRepository.save(student);
    }

    // UPDATE an existing student
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = getStudentById(id);
        existing.setFirstName(updatedStudent.getFirstName());
        existing.setLastName(updatedStudent.getLastName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setAge(updatedStudent.getAge());
        existing.setGrade(updatedStudent.getGrade());
        return studentRepository.save(existing);
    }

    // DELETE a student
    public void deleteStudent(Long id) {
        Student existing = getStudentById(id);
        studentRepository.delete(existing);
    }
}