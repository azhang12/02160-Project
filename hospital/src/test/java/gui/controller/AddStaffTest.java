package gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gui.model.Session;
import gui.model.Data;
import gui.views.AddStaffView;
import gui.views.EditStaffView;

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
	public void testEditStaff() {
		List<String> newData = new ArrayList<String>();
		newData.add("name");
		newData.add("name2");
		newData.add("Department01");
		newData.add("DOCTOR");
		Session s = new Session();
		ApplicationController app = new ApplicationController();
		Data d = new Data();
		DataController dc = new DataController(app,d,s);
		EditStaffController c = new EditStaffController(s,dc);
		EditStaffView  view = new EditStaffView(c,newData);
		view.setVisible(true);
		view.setVisible(true);
		
		
		int k=0;
		k=1;
		
	}
}
