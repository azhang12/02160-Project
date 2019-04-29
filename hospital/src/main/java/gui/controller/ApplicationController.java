package gui.controller;


import gui.model.StaffData;
import gui.model.Session;
import gui.views.StaffDataView;
import gui.views.RegisterPatientView;
import hospital.System;
public class ApplicationController {
	
	private LoginController loginController;
	private StaffDataController dataController;
	
	
	public void manageData(Session session) {
		dataController = new StaffDataController(this, new Data(), session);
		StaffDataView invView = new StaffDataView(dataController);
		dataController.setView(invView);
		dataController.display();
	}
	
	
	
	public void login() {
		
		loginController = new LoginController(this);
		loginController.display();
	}
	
	
	
	public static void main(String[] args) {
		
		ApplicationController app = new ApplicationController();
		StaffData d = new StaffData(System.loadData("src/test/data/departments.csv" , "src/test/data/staff.csv", "src/test/data/patients.csv"));
		Session s = new Session();
		StaffDataController c = new StaffDataController(app,d,s);
		
		StaffDataView view = new StaffDataView(c);
		c.setView(view);
		view.setVisible(true);
		
		
	}

}
