package hospital;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaffPropertyTesting {
	JobRole job1 = JobRole.DOCTOR;
	JobRole job2 = JobRole.CLERK;
	InpatientDepartment dep = new InpatientDepartment("Dep01",8);
	OutpatientDepartment dep2 = new OutpatientDepartment("Dep05");
	Staff test = new Staff("Kilian", "Speiser", job1,"email", 2, new StaffAccess(), dep);
	Staff test2 = new Staff("Michelle", "Obama", job2,"email", 3, new ClericalAccess(), dep2);
	
	
	@Test
	public void getFirstNameTest() {
		assertEquals(test.getFirstName(),"Kilian");
	}
	
	@Test
	public void setFirstNameTest() {
		test.setFirstName("Michael");
		assertEquals(test.getFirstName(),"Michael");
	}
	
	@Test
	public void getLastNameTest() {
		assertEquals(test.getLastName(),"Speiser");
		
	}
	
	@Test
	public void setLastNameTest() {
		test.setLastName("Vick");
		assertEquals(test.getLastName(),"Vick");
	}
	@Test
	public void getJobRoleTest() {
		
		assertEquals(test.getJobRole(),JobRole.DOCTOR);
		
	}
	@Test
	public void setJobRoleTest() {
		test.setJobRole(JobRole.NURSE);
		assertEquals(test.getJobRole(),JobRole.NURSE);
	}
	
	@Test
	public void getEMailTest() {
		assertEquals(test.getEmail(),"email");
		
	}
	
	@Test
	public void setEMailTest() {
		test.setEmail("email.dk");
		assertEquals(test.getEmail(),"email.dk");
		
	}
	@Test
	public void getStaffNumberTest() {
		assertEquals(test.getStaffNumber(),2);
		
	}
	
	@Test
	public void setStaffNumberTest() {
		test.setStaffNumber(4);
		assertEquals(test.getStaffNumber(),4);
	}
	@Test 
	public void getDepartmentTest() {
		assertEquals(test.getDepartment(),dep);
		
	}
	@Test 
	public void setDepartmentTest() {
		
		assertEquals(test.getDepartment(),dep);
		assertEquals(test2.getDepartment(),dep2);
		test2.setDepartment(dep2);
		assertEquals(test2.getDepartment(),dep2);
		test2.setDepartment(dep2);
		assertEquals(test2.getDepartment() , dep2);
	}
	@Test public void getAccessLevelTest() {
		assertTrue(test.getAccessLevel().getPatientDataAccess());
	}
	@Test 
	public void setAccessLevelTest() {
		test.setAccessLevel(new ICTAccess());
		assertTrue(test.getAccessLevel() instanceof ICTAccess);
		
		
	}
	
	
	
	@Test public void copyStaff() {
		Staff test3 = test.copy();
		assertFalse(test3==test);
		assertEquals(test.getDepartment(),test3.getDepartment());
		assertEquals(test.getFirstName(),test3.getFirstName());
		assertEquals(test.getLastName(), test3.getLastName());
		assertEquals(test.getEmail(),test.getEmail());
		assertEquals(test.getJobRole(),test3.getJobRole());
		assertEquals(test.getStaffNumber(),test3.getStaffNumber());
		assertEquals(test.getAccessLevel(),test3.getAccessLevel());
		
		
		
	}
	
	
	

}
