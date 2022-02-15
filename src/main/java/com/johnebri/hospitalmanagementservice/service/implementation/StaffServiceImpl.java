package com.johnebri.hospitalmanagementservice.service.implementation;

import com.johnebri.hospitalmanagementservice.dao.StaffRepository;
import com.johnebri.hospitalmanagementservice.dto.staff.NewOrUpdateStaffRequest;
import com.johnebri.hospitalmanagementservice.model.Staff;
import com.johnebri.hospitalmanagementservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff newStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(NewOrUpdateStaffRequest request, Long staffId) throws Exception {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if(!staff.isPresent()) {
            throw new Exception("Staff does not exist");
        }
        Staff theStaff = staff.get();
        theStaff.setName(request.getName());
        return staffRepository.save(theStaff);
    }


}
