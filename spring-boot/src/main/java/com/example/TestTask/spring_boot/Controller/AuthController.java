package com.example.TestTask.spring_boot.Controller;

import com.example.TestTask.spring_boot.entity.SalesTrafficStatisticByAsin;
import com.example.TestTask.spring_boot.entity.User;
import com.example.TestTask.spring_boot.service.AuthService;
import com.example.TestTask.spring_boot.service.JwtService;
import com.example.TestTask.spring_boot.service.StatisticService;
import com.example.TestTask.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private  AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginDto) {
        return ResponseEntity.ok(authService.loginUser(loginDto.getUsername(), loginDto.getPassword()));
    }
}
