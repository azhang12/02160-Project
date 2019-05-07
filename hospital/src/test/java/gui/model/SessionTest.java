package gui.model;

import hospital.InpatientDepartment;
import hospital.JobRole;
import hospital.Staff;
import hospital.StaffAccess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SessionTest {

	Session s = new Session();
	Staff test = new Staff("Kilian", "Speiser", JobRole.DOCTOR,"kilian.speiser@hospital.dk", 2, new StaffAccess(), new InpatientDepartment("Dep01",3));
	
	@Test
	public void setGetUser() {
		assertEquals("No user yet",s.getUser(),null);
		s.setUser(test);
		assertEquals("test user ",s.getUser(),test);
	}
	
	@Test
	public void propertyTests() {
		s.setUser(test);
		assertEquals(s.getUserId(),test.getStaffNumber());
		assertEquals(s.getAccess(),test.getAccessLevel());
		assertEquals(s.getDepartment(),test.getDepartment().getName());
	}
}
