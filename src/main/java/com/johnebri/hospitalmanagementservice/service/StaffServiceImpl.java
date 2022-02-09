package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.dao.StaffRepository;
import com.johnebri.hospitalmanagementservice.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public Staff newStaff(Staff staff) {
        return staffRepository.save(staff);
    }

}
