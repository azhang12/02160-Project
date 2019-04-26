package hospital;

import static org.junit.Assert.*;

import org.junit.Test;
class Access{
	Access (){};
}
public class StaffPropertyTesting {
	JobRole job = JobRole.DOCTOR;
	Department dep = new Department("Department01");
	Department dep2 = new Department("Dep05");
	Staff test = new Staff("Kilian", "Speiser", job,"email", 2, new Access(), dep);
	Staff test2 = new Staff("Kilian", "Speiser", job,"email", 3, new Access(), dep);
	
	
	@Test
	public void getFirstNameTest() {
		assertTrue(test.getFirstName()=="Kilian");
		
	}
	
	@Test
	public void setFirstNameTest() {
		test.setFirstName("Michael");
		assertTrue(test.getFirstName()=="Michael");
	}
	
	@Test
	public void getLastNameTest() {
		assertTrue(test.getLastName()=="Speiser");
		
	}
	
	@Test
	public void setLastNameTest() {
		test.setLastName("Vick");
		assertTrue(test.getLastName()=="Vick");
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
		assertEquals(test2.getDepartment(),dep);
		test2.setDepartment(dep2);
		assertEquals(test2.getDepartment(),dep2);
		test2.setDepartment(new Department ("Department06"));
		assertEquals(test2.getDepartment().getName(),"Department06");
	}
	
	
	

}
