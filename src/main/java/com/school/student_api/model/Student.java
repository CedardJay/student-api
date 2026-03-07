package com.school.student_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private int age;

    private String grade;

    // No-args constructor
    public Student() {}

    // All-args constructor
    public Student(Long id, String firstName, String lastName, String email, int age, String grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.grade = grade;
    }

    // Getters
    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(String grade) { this.grade = grade; }
}