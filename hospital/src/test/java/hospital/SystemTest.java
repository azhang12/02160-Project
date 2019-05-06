package hospital;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SystemTest {
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
	public void registerPatientTest1(){
		Hospital hosp = add();
		System.registerPatient(hosp, "Max", "Ryan", "19927", "Reading", "+674645", true, "Denmark");
		assertEquals(hosp.getPatient().size(),4);
		
	}
	@Test
	public void admitPatient() {
		Hospital hosp = add();
		System.registerPatient(hosp, "Max", "Ryan", "19927", "Reading", "+674645", true, "Denmark");
		System.admitPatient(hosp, hosp.getPatient().get(3).getPatientNumber(), "D02");
		assertEquals(hosp.getDepartment().get(1),hosp.getPatient().get(3).getDepartment());
		
	}
	
	@Test
	public void dischargePatient() {
		Hospital hosp = add();
		System.dischargePatient(hosp,pat1.getPatientNumber());
		assertEquals(pat1.getDepartment(),null);
		assertEquals(dep1.getPatients().indexOf(pat1),-1);
	}
	

}
