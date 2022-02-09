package com.johnebri.hospitalmanagementservice.dao;

import com.johnebri.hospitalmanagementservice.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
