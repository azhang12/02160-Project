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
	Patient pat2 = new Patient("Victor", "Slirt", dep2, "19931222", "copenhagen", "+213123",true, 12,"Germany", null, 12);
	ArrayList <Patient> p = new ArrayList<Patient>();
	public Hospital add() {
		d.add(dep1);
		d.add(dep2);
		s.add(staff1);
		s.add(staff2);
		p.add(pat1);
		p.add(pat2);
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
	
	@Test
	public void bedUpdate() {
		Hospital hosp = add();
		
		assertTrue("pat1 is registered in D01",dep1.getPatients().indexOf(pat1)!=-1);
		pat1.setDepartment(dep2);
		assertEquals("Bed is available",pat1.getBed(),null);
		
	}
}
