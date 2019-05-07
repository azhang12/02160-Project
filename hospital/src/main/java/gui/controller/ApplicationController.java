// 

package gui.controller;


import gui.model.Data;
import gui.model.Session;
import gui.views.DataView;
import hospital.System;
public class ApplicationController {
	
	private LoginController loginController;
	private DataController dataController;
	public String departmentFile ="src/test/data/depExport.csv";
	public String staffFile ="src/test/data/staffExport.csv";
	public String patFile="src/test/data/patExport.csv";
	
	
	public void manageData(Session session) {
		Data d = new Data(System.loadData(departmentFile, staffFile, patFile),"Staff",session);
		DataController c = new DataController(this,d,session);
		DataView view = new DataView(c);
		c.setView(view,"Department");
		
		view.setVisible(true);
	}
	
	
	
	public void login() {
		Session sess = new Session();
		Data d = new Data(System.loadData(departmentFile , staffFile, patFile),"Department",new Session ());
		loginController = new LoginController(this,d);
		loginController.display();
	}
	
	
	
	public static void main(String[] args) {
		
		ApplicationController app = new ApplicationController();
		app.login();
		
	}

}
