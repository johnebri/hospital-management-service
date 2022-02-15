package com.johnebri.hospitalmanagementservice.service.implementation;

import com.johnebri.hospitalmanagementservice.dao.StaffRepository;
import com.johnebri.hospitalmanagementservice.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    StaffRepository staffRepository;

    public void validateUuid(String uuid) throws Exception {
        if(!staffRepository.findByUuid(uuid).isPresent()) {
            throw new Exception("Invalid UUID");
        }
    }
}
