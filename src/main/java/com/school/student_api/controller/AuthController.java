package com.school.student_api.controller;

import com.school.student_api.model.AuthRequest;
import com.school.student_api.model.AuthResponse;
import com.school.student_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register endpoint
    // POST http://localhost:8081/api/auth/register
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    // Login endpoint
    // POST http://localhost:8081/api/auth/login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}