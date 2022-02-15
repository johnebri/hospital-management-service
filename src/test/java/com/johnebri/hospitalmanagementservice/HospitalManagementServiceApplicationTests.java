package com.johnebri.hospitalmanagementservice;

import com.johnebri.hospitalmanagementservice.dao.StaffRepository;
import com.johnebri.hospitalmanagementservice.dto.staff.NewOrUpdateStaffRequest;
import com.johnebri.hospitalmanagementservice.model.Staff;
import com.johnebri.hospitalmanagementservice.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class HospitalManagementServiceApplicationTests {

	@Autowired
	private StaffService staffService;

	@MockBean
	private StaffRepository staffRepository;

	@Test
	public void createStaffTest() {
		Staff staff = new Staff();
		when(staffRepository.save(staff)).thenReturn(staff);
		assertEquals(staff, staffService.newStaff(staff));
	}

	@Test
	public void updateStaffTest() {
		Long staffId = 1L;
		Staff staff = new Staff();
		NewOrUpdateStaffRequest request = new NewOrUpdateStaffRequest();
		request.setName(staff.getName());
		when(staffRepository.save(staff)).thenReturn(staff);
		assertEquals(staff, staffService.updateStaff(request, staffId));
	}

}
