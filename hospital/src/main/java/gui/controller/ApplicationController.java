package gui.controller;


import gui.model.Data;
import gui.model.Session;
import gui.views.DataView;
import gui.views.RegisterPatientView;

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
		//System.loadData(String departmentsFile, String StaffFile, String PatientFile);
		app.login();
	}

}
