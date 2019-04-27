package gui.controller;


import gui.model.Data;
import gui.model.Session;
import gui.views.DataView;

public class ApplicationController {
	
	private LoginController loginController;
	private DataController dataController;
	
	public void manageData(Session session) {
		dataController = new DataController(new Data(), session);
		
		
		DataView invView = new DataView(dataController);
		dataController.setView(invView);
		dataController.display();
	}
	
	public void login() {
		loginController = new LoginController(this);
		loginController.display();
	}
	
	
	public static void main(String[] args) {
		ApplicationController app = new ApplicationController();
		app.login();
	}

}
