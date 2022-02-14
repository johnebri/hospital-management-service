package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.dto.staff.NewOrUpdateStaffRequest;
import com.johnebri.hospitalmanagementservice.model.Staff;

public interface StaffService {
    Staff newStaff(NewOrUpdateStaffRequest request);
    Staff updateStaff(NewOrUpdateStaffRequest request, Long StaffId);
}
