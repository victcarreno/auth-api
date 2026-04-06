package com.victor.auth_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victor.auth_api.dto.AuthResponse;
import com.victor.auth_api.dto.LoginRequest;
import com.victor.auth_api.dto.RegisterRequest;
import com.victor.auth_api.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        System.out.println(">>> [REGISTER] Username: " + request.getUsername());
        try {
            AuthResponse response = authService.register(request);
            System.out.println(">>> [REGISTER] SUCCESS");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(">>> [REGISTER] ERROR: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        System.out.println(">>> [LOGIN] Username: " + request.getUsername());
        try {
            AuthResponse response = authService.login(request);
            System.out.println(">>> [LOGIN] SUCCESS");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(">>> [LOGIN] ERROR: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body(null);
        }
    }
}