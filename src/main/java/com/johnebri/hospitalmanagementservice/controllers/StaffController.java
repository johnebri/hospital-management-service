package com.johnebri.hospitalmanagementservice.controllers;

import com.johnebri.hospitalmanagementservice.dto.BaseResponse;
import com.johnebri.hospitalmanagementservice.dto.BaseResponseWrapper;
import com.johnebri.hospitalmanagementservice.dto.staff.NewOrUpdateStaffRequest;
import com.johnebri.hospitalmanagementservice.model.Staff;
import com.johnebri.hospitalmanagementservice.service.StaffService;
import com.johnebri.hospitalmanagementservice.service.ValidationService;
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

    @Autowired
    ValidationService validationService;

    @PostMapping
    public ResponseEntity<?> createStaff(@RequestBody NewOrUpdateStaffRequest request)  {
        BaseResponse<Staff> baseResponse = new BaseResponse<>();

        Staff staff = new Staff();
        UUID uuid = UUID.randomUUID();
        staff.setName(request.getName());
        staff.setUuid(uuid.toString());
        return baseResponse.getResponse(true, "New Staff Created Successfully", staffService.newStaff(staff), HttpStatus.OK);
    }

    @PutMapping("/{staffId}")
    public ResponseEntity<?> updateStaff(@RequestBody NewOrUpdateStaffRequest request, @PathVariable Long staffId, @RequestHeader("Authorization") String authorization) throws Exception {
        validationService.validateUuid(authorization);
        BaseResponse<Staff> baseResponse = new BaseResponse<>();
        return baseResponse.getResponse(true, "Staff updated successfully", staffService.updateStaff(request, staffId), HttpStatus.OK);
    }
}
