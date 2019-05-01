package gui.controller;

import org.junit.Test;

import gui.model.Session;
import gui.model.StaffData;
import gui.views.AddStaffView;

public class AddStaffTest {

	@Test
	public void testView() {
		Session s = new Session();
		ApplicationController app = new ApplicationController();
		StaffData d = new StaffData();
		StaffDataController dc = new StaffDataController(app,d,s);
		AddStaffController c = new AddStaffController(s,dc);
		AddStaffView  view = new AddStaffView(c);
		view.setVisible(true);
		view.setVisible(true);
	}
}
