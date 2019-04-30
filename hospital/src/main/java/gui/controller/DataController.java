package gui.controller;

import java.util.List;


import javax.swing.JTextField;


import gui.model.FilterStaffData;
import gui.model.Session;
import gui.model.Data;
import gui.views.AddStaffView;
import gui.views.FilterStaffView;
import gui.views.DataView;

public class DataController {
	
	
	private Data dataModel;
	private Session sessionModel;
	private DataView view;
	private ApplicationController application;
	
	
	public DataController (ApplicationController app, Data data, Session session) {
		this.dataModel = data;
		this.sessionModel = session;
	}
	
	
	
	

	public void deleteItem(int selectedRow) {
		///TO-DO
	}

	public void setView(DataView view) {
		this.view = view;
		this.view.setTableModel(dataModel);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}
	
	


	public void AddPersonClicked() {
		
		AddStaffController c = new AddStaffController(sessionModel,this);
		AddStaffView view = new AddStaffView(c);
		c.setView(view);
		view.setVisible(true);
		
	
		
	}
	
	public void updateView() {
		this.view.setTableModel(dataModel);
	}



	public void addPerson(List<JTextField> txtEntries) {
		
			dataModel.addStaff(txtEntries);
			
	}


	public void DeletePersonClicked(int selectedRow) {
		if (selectedRow >= 0) {
			int staffNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
			dataModel.removeStaff(staffNo);
		}
		
	}



	public void FilterStaff(List<JTextField> txtEntries) {
		// TODO Auto-generated method stub
		
	}



	public void FilterClicked() {
		FilterStaffController c = new FilterStaffController(sessionModel,this,new FilterStaffData(dataModel.getData()));
		FilterStaffView view = new FilterStaffView(c);	
		c.setView(view);
		view.setVisible(true);
		
	}





	public void ShowData(String s) {
		this.dataModel= new Data(dataModel.getData(),s);
		this.view.setTableModel(dataModel);
		updateView();
		
	}





	




	

}
