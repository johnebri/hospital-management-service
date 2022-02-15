package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.dto.staff.NewOrUpdateStaffRequest;
import com.johnebri.hospitalmanagementservice.model.Staff;

public interface StaffService {
    Staff newStaff(Staff staff);
    Staff updateStaff(NewOrUpdateStaffRequest request, Long StaffId) throws Exception;
}
