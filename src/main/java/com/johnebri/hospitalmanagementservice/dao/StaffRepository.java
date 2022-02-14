package com.johnebri.hospitalmanagementservice.dao;

import com.johnebri.hospitalmanagementservice.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByUuid(String uuid);
}
