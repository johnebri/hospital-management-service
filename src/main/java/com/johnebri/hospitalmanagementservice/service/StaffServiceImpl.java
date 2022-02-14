package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.dao.StaffRepository;
import com.johnebri.hospitalmanagementservice.dto.staff.NewOrUpdateStaffRequest;
import com.johnebri.hospitalmanagementservice.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff newStaff(NewOrUpdateStaffRequest request) {
        Staff staff = new Staff();
        UUID uuid = UUID.randomUUID();
        staff.setName(request.getName());
        staff.setUuid(uuid.toString());
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(NewOrUpdateStaffRequest request, Long staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if(!staff.isPresent()) {
            return null;
        }
        Staff theStaff = staff.get();
        theStaff.setName(request.getName());
        return staffRepository.save(theStaff);

    }


}
