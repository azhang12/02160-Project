package gui.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gui.model.Session;
import gui.model.Data;
import gui.views.AddStaffView;
import hospital.Department;
import hospital.Hospital;
import hospital.ICTAccess;
import hospital.InpatientDepartment;
import hospital.JobRole;
import hospital.OutpatientDepartment;
import hospital.Patient;
import hospital.Reader;
import hospital.Staff;
import hospital.StaffAccess;

public class AddStaffTest {
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
	List<String> txt = new ArrayList<String>();
	List<String> txtNames = new ArrayList<String>();
	
	public Hospital add() {
		d.add(dep1);
		d.add(dep2);
		s.add(staff1);
		s.add(staff2);
		p.add(pat1);
		p.add(pat2);
		p.add(pat3);
		txt.add("kilian");
		txt.add("Ray");
		txt.add("D01");
		txt.add("DOCTOR");
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Department Name");
		txtNames.add("Job Role");
		return new Hospital(d,s,p);
	}

	@Test
	public void testView() {
		Session s = new Session();
		s.setUser(staff1);
		ApplicationController app = new ApplicationController();
		Hospital h = add();
		Data d = new Data(h,"Staff",s);
		DataController dc = new DataController(app,d,s);
		AddStaffController c = new AddStaffController(s,dc);
		AddStaffView  view = new AddStaffView(c);
		view.setVisible(true);
		view.setVisible(true);
		
	}
	@Test
	public void addStaffClickedTest() {
		Hospital h = add();
		Session s = new Session();
		s.setUser(staff1);
		Data d = new Data(h,"Staff",s);
		ApplicationController app = new ApplicationController();
		DataController dc = new DataController(app,d,s);
		AddStaffController c = new AddStaffController(s,dc);
		AddStaffView  view = new AddStaffView(c);
		c.setView(view);
		
		
		
		
		c.addStaffClicked(txt, txtNames);
		int last = dep1.getStaff().size();
		assertEquals(dep1.getStaff().get(last-1).getFirstName(),"kilian");
		assertEquals(dep1.getStaff().get(last-1).getLastName(),"Ray");
		assertEquals(dep1.getStaff().get(last-1).getJobRole(),JobRole.DOCTOR);
		assertEquals(dep1.getStaff().get(last-1).getDepartment(),dep1);
	}
	
	
	

}
