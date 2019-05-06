package hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FinderTest {
	Department d = new InpatientDepartment("Department02",4);
	List<Department> dep = new ArrayList<Department>();
	JobRole job = hospital.JobRole.DOCTOR;
	Staff test = new Staff("Kilian", "Speiser", job,"kilian.speiser@hospital.dk", 2, new StaffAccess(), d);
	Staff test2 = new Staff("Kilian", "Speiser", job,"kilian.speiser2@hospital.dk", 3, new StaffAccess(), d);
	Staff test3 = new Staff("Kilian", "Speiserer", job,"email", 12, new StaffAccess(), d);
	List<Staff> staff = new ArrayList<Staff>();
	
	@Test
	public void findDepartmentTest() {
		
		dep.add(d);
		Department m = Finder.findDepartment("Department02", dep);
		
		assertEquals(m.getName(),"Department02");
		assertEquals("not found",Finder.findDepartment("lol", dep),null);
		
		
	}
	
	@Test
	public void findAccessTest() {
		
		
		Access acc = Finder.findAccess(JobRole.DOCTOR);
		assertTrue(acc instanceof StaffAccess);
		acc = Finder.findAccess(JobRole.NURSE);
		assertTrue(acc instanceof StaffAccess);
		acc = Finder.findAccess(JobRole.IT);
		assertTrue(acc instanceof ICTAccess);
		acc = Finder.findAccess(JobRole.CLERK);
		assertTrue(acc instanceof ClericalAccess);
		
		
		
		
		
	}
	
	@Test
	public void findEmailtest() {
		staff.add(test);
		
		String mail = Finder.findEmail(staff, "Kilian", "Speiser");
		assertTrue(mail.equals("kilian.speiser2@hospital.dk"));
		staff.add(test2);
		test.setEmail(mail);
		String mail2 = Finder.findEmail(staff, "Kilian", "Speiser");
		assertTrue(mail2.equals("kilian.speiser3@hospital.dk"));
		
		staff.add(test3);
		assertTrue("max.me@hospital.dk".equals(Finder.findEmail(staff,"Max", "Me")));
		
		
		
	}
	
	@Test 
	public void findStaffIntTest() {
		staff.add(test);
		staff.add(test2);
		staff.add(test3);
		int n = Finder.findStaffInt(staff, 12);
		assertEquals("Staff found at pos. 3 (index 2", n,2);
		
		int n2 = Finder.findStaffInt(staff, 4);
		assertEquals("Staff number not existent",n2,-1);
	}
	
	
	@Test
	public void findStaffTest() {
		staff.add(test);
		staff.add(test2);
		staff.add(test3);
		
		Staff n = Finder.findStaff(staff, 12);
		assertEquals("Staff found at pos. 3 (index 2)", n,staff.get(2));
		
		Staff n2 = Finder.findStaff(staff, 4);
		assertEquals("Staff number not existent",n2,null);
		
		
	}

	@Test
	public void findJobRole() {
		staff.add(test);
		assertEquals(JobRole.DOCTOR,Finder.findJobRole("DOCTOR"));
		
	}
	
	@Test 
	public void findBedTest() {
		Patient pat = new Patient();
		List<Bed> beds = new ArrayList<Bed>();
		Bed test = new Bed(pat,221);
		beds.add(test);
		
		assertEquals(Finder.findBed(221, beds),test);
		assertEquals("Bed not in the list", Finder.findBed(222, beds),null);
		
		
	}
	
	@Test
	public void findPatient() {
		InpatientDepartment dep = new InpatientDepartment("hi",12);
		
		Patient pat = new Patient("Kilian","Speiser",dep,"Dezember","Germany","342323",true,123421,"Germany",dep.getBed().get(3),0);
		List<Patient> patients = new ArrayList<Patient>();
		patients.add(new Patient());
		patients.add(pat);
		
		assertEquals(Finder.findPatient(123421, patients),pat);
		assertEquals("not found",Finder.findPatient(123422, patients),null);
		assertEquals(pat.getBed().getPatient(),pat);
		assertEquals(pat,pat.getBed().getPatient());
		
		
	}
	
	@Test
	public void constructorTest() {
		Finder f = new Finder();
		
	}
}
