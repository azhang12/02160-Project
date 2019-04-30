package gui.controller;

import java.util.List;

import gui.model.Session;
import gui.model.Data;
import gui.model.User;
import gui.views.LoginView;
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
		User user = new User();
		List<Staff> staff = data.getData().getStaff();
		try {
			int id = Integer.parseInt(username);
			user.setUserId(id);
			
			if ((!username.isEmpty())) {
				for(Staff s : staff) {
					if(s.getStaffNumber()==id) {
						session.setUser(user);
						session.setRole(s.getJobRole().toString());
						session.setDepartment(s.getDepartment().getName());
						view.setVisible(false);
						application.manageData(session);
						return true;
					}
				}
				
			} else {
				view.showError();
			}
		}
		
		catch(Exception e) {
			view.showError();
		}
		view.showError();
		return false;
		
		
		
		
	}

	public void display() {
		view.setVisible(true);
	}
}
