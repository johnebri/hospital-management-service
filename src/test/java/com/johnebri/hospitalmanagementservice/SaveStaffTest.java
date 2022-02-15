package com.johnebri.hospitalmanagementservice;

import com.johnebri.hospitalmanagementservice.dao.StaffRepository;
import com.johnebri.hospitalmanagementservice.model.Staff;
import com.johnebri.hospitalmanagementservice.service.StaffService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class SaveStaffTest {

    @Autowired
    private StaffService staffService;

    @MockBean
    private StaffRepository staffRepository;

    @Test
    public void whenSaveStaffShouldReturnStaff() {
        Staff staff = new Staff();
        staff.setName("Test Staff");
        when(staffRepository.save(ArgumentMatchers.any(Staff.class))).thenReturn(staff);
        Staff created = staffService.newStaff(staff);
        assertThat(created.getName()).isSameAs(staff.getName());
        verify(staffRepository).save(staff);
    }

}
