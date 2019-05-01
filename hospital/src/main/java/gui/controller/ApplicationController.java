package gui.controller;


import gui.model.Data;
import gui.model.Session;
import gui.views.DataView;
import hospital.System;
public class ApplicationController {
	
	private LoginController loginController;
	private DataController dataController;
	private String departmentFile ="src/test/data/depExport.csv";
	private String staffFile ="src/test/data/staffExport.csv";
	private String patFile="src/test/data/patExport.csv";
	
	
	public void manageData(Session session) {
		Data d = new Data(System.loadData(departmentFile, staffFile, patFile),"Staff");
		DataController c = new DataController(this,d,session);
		DataView view = new DataView(c);
		c.setView(view,"Staff");
		view.setVisible(true);
	}
	
	
	
	public void login(Data d) {
		
		loginController = new LoginController(this,d);
		loginController.display();
	}
	
	
	
	public static void main(String[] args) {
		Data d = new Data(System.loadData("src/test/data/departments.csv" , "src/test/data/staff.csv", "src/test/data/patients.csv"),"Staff");
		ApplicationController app = new ApplicationController();
		app.login(d);
		
	}

}
