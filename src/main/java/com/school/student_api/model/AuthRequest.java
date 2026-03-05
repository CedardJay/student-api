package com.school.student_api.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String fullName;
    private String email;
    private String password;
}