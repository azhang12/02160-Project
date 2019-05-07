package gui.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gui.model.Data;
import gui.model.Session;
import hospital.Hospital;
import hospital.InpatientDepartment;
import hospital.JobRole;
import hospital.Staff;
import hospital.StaffAccess;
import hospital.System;


public class LoginControllerTest {
	
	ApplicationController app = new ApplicationController();
	Hospital hosp = new Hospital();
	Staff test = new Staff("Kilian", "Speiser", JobRole.DOCTOR,"kilian.speiser@hospital.dk", 2, new StaffAccess(), new InpatientDepartment("Dep01",3));
	Data data = new Data(hosp,"Staff",new Session());
	
	LoginController controller = new LoginController(app,data);
	
	
	@Test
	public void validateCredentialsTest() {
		hosp.addStaff(test);
		assertTrue("User was found",controller.validateCredentials("2"));
	}
	
	@Test
	public void validateTestEmpty() {
		assertFalse("No input",controller.validateCredentials(""));
	}
	@Test
	public void validateTestNotFound() {
		assertFalse("No input",controller.validateCredentials("4"));
	}
	
	
}


