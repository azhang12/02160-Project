package gui.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gui.model.StaffData;
import hospital.Hospital;
import hospital.JobRole;
import hospital.Staff;
import hospital.System;

public class LoginControllerTest {
	
	ApplicationController app = new ApplicationController();
	Hospital hosp = System.loadData("src/test/data/departments.csv" , "src/test/data/staff.csv", "src/test/data/patients.csv");
	
	StaffData data = new StaffData(hosp,"Staff");
	LoginController controller = new LoginController(app,data);
	
	@Test
	public void validateCredentialsTest() {
		if(System.registerStaff(hosp,"Kilian", "Speiser", "Doctor", "Department01"));
		controller.validateCredentials("3");
		Staff s = (Staff)hosp.getStaff().get(2);
		assertEquals(hosp.getStaff().size(),3);
		assertTrue("Staff was not added as Department is missing",s.getStaffNumber()==3);
	}
	
}

