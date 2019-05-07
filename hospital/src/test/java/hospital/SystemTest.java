package hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	Patient pat2 = new Patient("Victor", "Slirt", dep2, "19931222", "copenhagen", "+213123",true, 10,"Germany", null, 1);
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
	public void admitOutPatient() {
		Hospital hosp = add();
		assertEquals("Department Property has Changed",hosp.getDepartment().get(1).getPatients().size(),1);
		System.registerPatient(hosp, "Max", "Ryan", "19927", "Reading", "+674645", true, "Denmark");
		System.admitPatient(hosp, hosp.getPatient().get(3).getPatientNumber(), "D02");
		assertEquals("Department Property has Changed",hosp.getDepartment().get(1).getPatients().size(),2);
		
		
	}
	
	@Test
	public void admitInPatient() {
		Hospital hosp = add();
		assertEquals("Department Property has Changed",hosp.getDepartment().get(0).getPatients().size(),2);
		System.registerPatient(hosp, "Max", "Ryan", "19927", "Reading", "+674645", true, "Denmark");
		System.admitPatient(hosp, hosp.getPatient().get(3).getPatientNumber(), "D01");
		assertEquals("Department Property has Changed",hosp.getDepartment().get(0).getPatients().size(),3);
		
	}
	
	@Test
	public void dischargePatient() {
		Hospital hosp = add();
		System.dischargePatient(hosp,pat1.getPatientNumber());
		assertEquals(pat1.getDepartment(),null);
		assertEquals(dep1.getPatients().indexOf(pat1),-1);
	}
	
	@Test 
	public void addStaffTest() {
		Hospital hosp = add();
		assertEquals("Correct",System.registerStaff(hosp,"kilian", "ray", "DOCTOR", "D01" ),true);
		assertEquals("Wrong Department",System.registerStaff(hosp,"kilian", "ray", "DOCTOR", "D03" ),false);
		assertEquals("Wrong JobRole",System.registerStaff(hosp,"kilian", "ray", "DOCTO", "D01" ),false);
		
	}
	
	
	@Test
	public void addInpatientDepartmentTest() {
		Hospital hosp = add();
		System.addDepartment(hosp, "D03", 8);
		InpatientDepartment dep = (InpatientDepartment)hosp.getDepartment().get(hosp.getDepartment().size()-1);
		assertEquals(dep.getName(),"D03");
		assertEquals(dep.getBed().size(),8);
		
	}
	@Test
	public void addOutpatientDepartmentTest() {
		Hospital hosp = add();
		System.addDepartment(hosp, "D04", 0);
		OutpatientDepartment dep = (OutpatientDepartment)hosp.getDepartment().get(hosp.getDepartment().size()-1);
		assertEquals(dep.getName(),"D04");
		assertEquals(dep.getQueue().size(),0);
		
	}
	
	@Test 
	public void callPatientTestInDepartment() {
		Hospital hosp = add();
		System.callPatient(hosp,pat3,4);
		assertEquals("Bed was updated",dep1.getBed().get(3),pat3.getBed());
		assertEquals("Bed was updated by observer pattern",dep1.getBed().get(3).getPatient(),pat3);
				
	}
	@Test 
	public void callPatientTestInDepartmentOccupiedBed() {
		Hospital hosp = add();
		
		assertEquals("Bed is occupied, returns false",System.callPatient(hosp,pat3,1),false);
		
	}
	
	@Test 
	public void callPatientTestOutDepartment() {
		Hospital hosp = add();
		assertEquals(dep2.getPatients().size(),1);
		//System.admitPatient(hosp, 10, "D02");
		//assertEquals(dep2.getPatients().size(),1);
		//assertEquals(dep2.getQueue().size(),1);
		System.callPatient(hosp,pat2,0);
		assertEquals("Patient automatically discharged",dep2.getPatients().size(),0);
		//assertEquals("Queue was updated",dep2.getQueue().peek(),pat2);
		//assertEquals("Queue was updated in noth places where it is saved",pat2.getQueueNumber(),1);
	
	}
	
	@Test 
	public void editStaffTest() {
		Hospital hosp = add();
		String newFirstName = "Michael";
		String newLastName = "Michael";
		String newDepartment = "D02";
		String newJob = "Doctor";
		
		System.editStaff(hosp,staff1,newFirstName, newLastName, newDepartment,newJob);
		assertEquals(staff1.getFirstName(),newFirstName);
		assertEquals(staff1.getLastName(),newLastName);
		assertEquals(staff1.getDepartment(),dep2);
		assertEquals(staff1.getJobRole(),JobRole.DOCTOR);
		
		//Check if Department is updated
		
		assertEquals("Staff is added to the Department",Finder.findStaff(dep2.getStaff(), staff1.getStaffNumber()),staff1);
	}
	
	@Test 
	public void editStaffTestWronJob() {
		Hospital hosp = add();
		String newFirstName = "Michael";
		String newLastName = "Michael";
		String newDepartment = "D02";
		String newJob = "Doc";
		
		assertFalse("WrongJobRole",System.editStaff(hosp,staff1,newFirstName, newLastName, newDepartment,newJob));
		
	}
	@Test 
	public void editStaffTestWrongDep() {
		Hospital hosp = add();
		String newFirstName = "Michael";
		String newLastName = "Michael";
		String newDepartment = "D05";
		String newJob = "Doctor";
		
		assertFalse("WrongJ Department",System.editStaff(hosp,staff1,newFirstName, newLastName, newDepartment,newJob));
		
	}
	
	@Test 
	public void removeStaffTest() {
		Hospital hosp = add();
		System.removeStaff(hosp, staff1.getStaffNumber());
		assertEquals("Staff also removed from Department List",dep1.getStaff().size(),0);
		
	}
	@Test 
	public void removePatientTest() {
		Hospital hosp = add();
		System.removePatient(hosp, pat1.getPatientNumber());
		assertEquals("Patients also removed from Department List",dep1.getPatients().size(),1);
		
	}
	
	@Test
	public void editPatientTest() {
		Hospital hosp = add();
		System.editPatient(hosp, pat1, pat2.getFirstName(), pat2.getLastName(), pat2.getBirthday(),pat2.getAddress(), pat2.getPhoneNumber(), pat2.getNationality());
		assertEquals(pat1.getFirstName(),(pat2.getFirstName()));
		assertEquals(pat1.getLastName(),pat2.getLastName());
		assertEquals(pat1.getBirthday(),pat2.getBirthday());
		assertEquals(pat1.getAddress(),pat2.getAddress());
		assertEquals(pat1.getPhoneNumber(),pat2.getPhoneNumber());
		assertEquals(pat1.getNationality(),pat2.getNationality());
		
		
	}
	@Test
	public void editPatientTestNull() {
		Hospital hosp = add();
		
		System.editPatient(hosp, pat1, null, null, null,null, null, null);
		assertEquals(pat1.getFirstName(),"Victoria");
		assertEquals(pat1.getLastName(),"Sirt");
		assertEquals(pat1.getBirthday(),"19931222");
		assertEquals(pat1.getAddress(),"copenhagen");
		assertEquals(pat1.getPhoneNumber(),"+213123");
		assertEquals(pat1.getNationality(),"Germany");
		
		
	}
	@Test 
	public void exportTest(){
		Hospital hosp = add();
		System.exportData(hosp);
		
	}
	
	@Test
	public void print() {
		Hospital hosp = add();
		System.printPDF(hosp);
	}
	
	
	

}
