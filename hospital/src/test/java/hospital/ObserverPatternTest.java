package hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ObserverPatternTest {
	
	Reader r = new Reader();
	InpatientDepartment dep1 = new InpatientDepartment("D01", 8);
	OutpatientDepartment dep2 = new OutpatientDepartment("D02");
	ArrayList <Department> d = new ArrayList<Department>();
	
	
	Staff staff1 = new Staff("Adrian","Petersen",JobRole.NURSE,"adrian.petersen@hospital.dk",142,new StaffAccess(),dep1);
	Staff staff2 = new Staff("Michelle", "Williams", JobRole.IT, "michelle.williams@hospital.dk", 111, new ICTAccess(), dep2);
	ArrayList <Staff> s = new ArrayList<Staff>();
	
	Patient pat1 = new Patient("Victoria", "Sirt", dep1, "19931222", "copenhagen", "+213123",true, 12,"Germany", dep1.getBed().get(0), 0 );
	Patient pat2 = new Patient("Victor", "Slirt", dep2, "19931222", "copenhagen", "+213123",true, 10,"Germany", null, 12);
	Patient pat3 = new Patient("Vic", "Smirt", dep1, "19931222", "copenhagen", "+213123",true,4,"Germany", null, 0);
	ArrayList <Patient> p = new ArrayList<Patient>();
	public Hospital add() {
		d.add(dep1);
		d.add(dep2);
		s.add(staff1);
		s.add(staff2);
		p.add(pat1);
		p.add(pat2);
		p.add(pat3);
		return new Hospital(d,s,p);
	}
	
	@Test
	public void autoUpdateStaff() {
		Hospital hosp = add();
		assertTrue(dep1.getStaff().indexOf(staff1)!=-1);
		staff1.setDepartment(dep2);
		
		assertTrue(dep2.getStaff().indexOf(staff1)!=-1);
		assertEquals(dep1.getStaff().size(),0);
		
	}

	@Test
	public void autoUpdatePatients() {
		Hospital hosp= add();
		assertTrue(dep1.getPatients().indexOf(pat1)!=-1);
		pat1.setDepartment(dep2);
		assertTrue(dep1.getPatients().indexOf(pat1)==-1);
		assertTrue(dep2.getPatients().indexOf(pat1)!=-1);
		
	}
	//Test Bed Update: two possible scenarios
	
	// Bed is occupied and a patient is assigned
	// Patient is already assigned to a bed
	// Patient is not assigned to any bed
	@Test
	public void bedUpdate() {
		// Bed is empty and a patient is assigned, patient doesn't have a bed yet
		Hospital hosp = add();
		
		assertTrue("pat3 is registered in D01",dep1.getPatients().indexOf(pat3)!=-1);
		Bed b = pat1.getBed();
		pat1.setDepartment(dep2);
		assertEquals("Bed is available",b.getPatient(),null);
		pat3.setBed(b, true);
		assertEquals("Pat 3 is in the Bed at dep1",b.getPatient(),pat3);
		assertEquals("Pat 3 is in the Bed at dep1",pat3.getBed(),b);
		
		
	}
	@Test
	public void bedUpdate2() {
		// Bed is empty and a patient is assigned, patient doesn't have a bed yet
			Hospital hosp = add();
				
			assertTrue("pat3 is registered in D01",dep1.getPatients().indexOf(pat3)!=-1);
			assertEquals("bed 3 in Dep01 is free", null, dep1.getBed().get(2).getPatient());
			pat3.setBed(dep1.getBed().get(2),true);
			assertEquals("Bed 3 in Dep01 is pat3 assigned to", pat3,dep1.getBed().get(2).getPatient() );
			assertEquals("Bed 3 in Dep01 is pat3 assigned to", pat3.getBed(),dep1.getBed().get(2) );
			
	}
	@Test
	public void bedUpdate3() {
		// Bed is empty and a patient is assigned, patient does have a bed yet
			Hospital hosp = add();
				
			assertTrue("pat1 is registered in D01",dep1.getPatients().indexOf(pat1)!=-1);
			assertEquals("bed 4 in Dep01 is free", null, dep1.getBed().get(3).getPatient());
			assertEquals("bed 7 in Dep01 is free", null, dep1.getBed().get(6).getPatient());
			pat1.setBed(dep1.getBed().get(6),true);
			assertEquals("Bed 7 in Dep01 is pat1 assigned to", pat1,dep1.getBed().get(6).getPatient() );
			assertEquals("Bed 7 in Dep01 is pat1 assigned to", pat1.getBed(),dep1.getBed().get(6) );
			
	}
	
}
