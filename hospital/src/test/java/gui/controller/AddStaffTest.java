package gui.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gui.model.Session;
import gui.model.Data;
import gui.views.AddStaffView;
import gui.views.EditStaffView;
import hospital.Finder;

public class AddStaffTest {

	@Test
	public void testView() {
		Session s = new Session();
		ApplicationController app = new ApplicationController();
		Data d = new Data();
		DataController dc = new DataController(app,d,s);
		AddStaffController c = new AddStaffController(s,dc);
		AddStaffView  view = new AddStaffView(c);
		view.setVisible(true);
		view.setVisible(true);
	}
	@Test
	public void addStaffClickedTest() {
		Session s = new Session();
		ApplicationController app = new ApplicationController();
		Data d = new Data();
		DataController dc = new DataController(app,d,s);
		AddStaffController c = new AddStaffController(s,dc);
		AddStaffView  view = new AddStaffView(c);
		view.setVisible(true);
		view.setVisible(true);
		List<String> txt = new ArrayList<String>();
		List<String> txtNames = new ArrayList<String>();
		txt.add("kilian");
		txt.add("Ray");
		txt.add("Department04");
		txt.add("DOCTOR");
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Department Name");
		txtNames.add("Job Role");
		
		c.addStaffClicked(txt, txtNames);
		assertEquals(d.getData().getDepartment().get(3).getStaff().get(0).getFirstName(),"kilian");
		assertEquals(d.getData().getDepartment().get(3).getStaff().get(0).getLastName(),"Ray");
		
		
		
		
		
	}

}
