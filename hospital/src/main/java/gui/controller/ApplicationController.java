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
		StaffData d = new StaffData(System.loadData("src/test/data/departments.csv" , "src/test/data/staff.csv", "src/test/data/patients.csv"),"Staff");
		StaffDataController c = new StaffDataController(this,d,session);
		StaffDataView view = new StaffDataView(c);
		c.setView(view);
		view.setVisible(true);
	}
	
	
	
	public void login(StaffData d) {
		
		loginController = new LoginController(this,d);
		loginController.display();
	}
	
	
	
	public static void main(String[] args) {
		StaffData d = new StaffData(System.loadData("src/test/data/departments.csv" , "src/test/data/staff.csv", "src/test/data/patients.csv"),"Staff");
		ApplicationController app = new ApplicationController();
		app.login(d);
		
	}

}
