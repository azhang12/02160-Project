package hospital;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import hospital.Reader;
public class ReaderTest {

	
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
	Exporter e = new Exporter();
	Reader r = new Reader();
	private String depFile="src/test/data/depReaderTest.csv";
	private String staffFile="src/test/data/staffReaderTest.csv";
	private String patFile="src/test/data/patReaderTest.csv";
	
	public Hospital add() {
		d.add(dep1);
		d.add(dep2);
		s.add(staff1);
		s.add(staff2);
		p.add(pat1);
		p.add(pat2);
		p.add(pat3);
		e.export(d, depFile);
		e.export(s, staffFile);
		e.export(p, patFile);
		return new Hospital(d,s,p);
	}
	
	@Test
	public void testReadDepartments() {
		Hospital h = add();
		List<Department> departments = r.readDepartment(depFile);
		assertEquals("2 Departments added",2,departments.size());
		
	}
	
	@Test
	public void testReadStaff() {
		
		Hospital h = add();
		List <Staff> staffList = r.readStaff(h.getDepartment(),staffFile);
		assertEquals("2 staffs added",2,staffList.size());
	}
	
	
	@Test
	public void testReadPatients() {
	
		Hospital h = add();
		List<Patient> patList = r.readPatients(h.getDepartment(),patFile);
		assertEquals("3 patients added",3,patList.size());
	}
	
	@Test 
	public void testStaffinDepartment(){
		Hospital h = add();
		ArrayList<Department> departments = r.readDepartment(depFile);
		ArrayList <Staff> staffList = r.readStaff(h.getDepartment(),staffFile);
		ArrayList<Patient> patList = r.readPatients(h.getDepartment(),patFile);
		Hospital hNeu = new Hospital(departments, staffList,patList);
		
		Staff staffNeu = hNeu.getStaff().get(0);
		Department depNeu = staffNeu.getDepartment();
		assertFalse("Staff works for the Department",depNeu.getStaff().indexOf(staffNeu)==-1);
	}
	
	@Test 
	public void testPatientsinDepartment(){
		Hospital h = add();
		ArrayList<Department> departments = r.readDepartment(depFile);
		ArrayList <Staff> staffList = r.readStaff(h.getDepartment(),staffFile);
		ArrayList<Patient> patList = r.readPatients(h.getDepartment(),patFile);
		Hospital hNeu = new Hospital(departments, staffList,patList);
		
		Patient patNeu = hNeu.getPatient().get(0);
		Department depNeu = patNeu.getDepartment();
		assertFalse("Patient is admitted to the Department01",depNeu.getPatients().indexOf(patNeu)==-1);
	}
	
	@Test
	public void testPatintQueue() {
		Hospital h = add();
		ArrayList<Department> departments = r.readDepartment(depFile);
		ArrayList <Staff> staffList = r.readStaff(h.getDepartment(),staffFile);
		ArrayList<Patient> patList = r.readPatients(h.getDepartment(),patFile);
		Hospital hNeu = new Hospital(departments, staffList,patList);
		Patient pat = hNeu.getPatient().get(1);
		OutpatientDepartment dep =((OutpatientDepartment) pat.getDepartment());
		assertTrue("Patient is added to Queue", dep.getQueue().contains(pat));
	}
	
	@Test 
	public void testException() {
		String exc = "depart.cs";
		assertEquals(r.read(exc),null);
		
	}
	
	
	

}
