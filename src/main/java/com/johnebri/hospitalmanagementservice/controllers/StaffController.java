package com.johnebri.hospitalmanagementservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("staff")
public class StaffController {

    @GetMapping()
    public String createStaff() {
        return "Creating new Staff memeber";
    }
}
