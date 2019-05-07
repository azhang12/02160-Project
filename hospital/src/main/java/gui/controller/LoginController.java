package gui.controller;

import java.util.List;

import gui.model.Session;
import gui.model.Data;
import gui.views.LoginView;
import hospital.Finder;
import hospital.Staff;

public class LoginController {

	private ApplicationController application;
	private Session session;
	private LoginView view;
	private Data data;
	
	public LoginController(ApplicationController application, Data d) {
		this.application = application;
		this.session = new Session();
		this.view = new LoginView(this);
		this.data=d;
	}
	
	
	//Daten auslesen!
	public boolean validateCredentials(String username) {
		List<Staff> staff = data.getData().getStaff();
		try {
			int id = Integer.parseInt(username);
			
			
			
				for(Staff s : staff) {
					if(s.getStaffNumber()==id) {
						session.setUser(Finder.findStaff(staff, id));
						view.setVisible(false);
						application.manageData(session);
						return true;
					}
				}
				
		}
		
		catch(Exception e) {
			view.showError("Wrong Input!");
			return false;
		}
		view.showError("User Id not found!");
		return false;
		
		
		
	}

	public void display() {
		view.setVisible(true);
	}
}
