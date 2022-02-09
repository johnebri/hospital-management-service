package com.johnebri.hospitalmanagementservice.controllers;

import com.johnebri.hospitalmanagementservice.model.Staff;
import com.johnebri.hospitalmanagementservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping()
    public ResponseEntity<?> createStaff(@RequestBody Staff staff) {
        UUID uuid = UUID.randomUUID();
        staff.setUuid(uuid.toString());
        return new ResponseEntity<Staff>(staffService.newStaff(staff), HttpStatus.OK);
    }
}
