package com.example.setup.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/health-check")
public class HealthCheck {
    @GetMapping
    public String index(){
        return "hi Server running \uD83D\uDD2A \uD83D\uDC80";
    }
}
