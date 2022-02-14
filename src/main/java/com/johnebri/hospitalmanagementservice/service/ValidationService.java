package com.johnebri.hospitalmanagementservice.service;

import com.johnebri.hospitalmanagementservice.dao.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    @Autowired
    StaffRepository staffRepository;

    public void validateUuid(String uuid) throws Exception {
        if(!staffRepository.findByUuid(uuid).isPresent()) {
            throw new Exception("Invalid UUID");
        }
    }
}
