package gui.controller;

import gui.model.Session;
import gui.model.User;
import gui.views.LoginView;

public class LoginController {

	private ApplicationController application;
	private Session session;
	private LoginView view;
	
	public LoginController(ApplicationController application) {
		this.application = application;
		this.session = new Session();
		this.view = new LoginView(this);
	}
	
	
	//Daten auslesen!
	public void validateCredentials(String username) {
		User user = new User();
		try {
			int id = Integer.parseInt(username);
			user.setUserId(id);
			
			if ((!username.isEmpty())) {
				session.setUser(user);
				view.setVisible(false);
				application.manageData(session);
			} else {
				view.showError();
			}
		}
		
		catch(Exception e) {
			view.showError();
		}
		
		
		
	}

	public void display() {
		view.setVisible(true);
	}
}
