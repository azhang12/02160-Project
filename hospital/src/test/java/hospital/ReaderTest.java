package hospital;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import hospital.Reader;
public class ReaderTest {

	Reader r = new Reader();
	ArrayList <Department> d = r.readDepartment("src/test/data/departments.csv");
	ArrayList <Staff> s = r.readStaff(d, "src/test/data/staff.csv");
	ArrayList <Patient> p = r.readPatients (d, "src/test/data/patients.csv");
	
	
	
	@Test
	public void testReadDepartments() {
		
		
		assertEquals(5,d.size());
		
	}
	
	@Test
	public void testReadStaff() {
		
		
		assertEquals(2,s.size());
		
		
	}
	
	
	@Test
	public void testReadPatients() {
	
		assertEquals(1,p.size());
	}
	
	@Test 
	public void testStaffinDepartment(){
		assertTrue("Staff works for the Department",1==d.get(2).getStaff().size());
	}
	
	@Test 
	public void testPatientsinDepartment(){
		assertTrue("Patient is admitted to the Department01",1==d.get(0).getPatients().size());
	}
	
	
	

}
