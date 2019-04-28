package gui.controller;


import gui.model.Data;
import gui.model.Session;
import gui.views.DataView;
import gui.views.RegisterPatientView;
import hospital.System;
public class ApplicationController {
	
	private LoginController loginController;
	private DataController dataController;
	private RegisterController regController;
	
	
	public void manageData(Session session) {
		dataController = new DataController(this, new Data(), session);
		DataView invView = new DataView(dataController);
		dataController.setView(invView);
		dataController.display();
	}
	
	public void register(Session session) {
		regController = new RegisterController(session);
		RegisterPatientView view = new RegisterPatientView(regController);
		regController.display();
		
		
	}
	
	public void login() {
		
		loginController = new LoginController(this);
		loginController.display();
	}
	
	
	
	public static void main(String[] args) {
		
		ApplicationController app = new ApplicationController();
		Data d = new Data(System.loadData("src/test/data/departments.csv" , "src/test/data/staff.csv", "src/test/data/patients.csv"));
		Session s = new Session();
		DataController c = new DataController(app,d,s);
		
		DataView view = new DataView(c);
		view.setVisible(true);
		
		
	}

}
