package com.bloodbank.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@CrossOrigin
public class PublicController {
    
    @GetMapping("/info")
    public String getSystemInfo() {
        return "Blood Bank Management System - Public API";
    }
    
    @GetMapping("/contact")
    public String getContactInfo() {
        return "Contact: bloodbank@example.com | Phone: 123-456-7890";
    }
}