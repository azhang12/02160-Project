package gui.controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import gui.model.FilterStaffData;
import gui.model.Session;
import gui.model.StaffData;
import gui.views.AddStaffView;
import gui.views.FilterStaffView;
import gui.views.StaffDataView;

public class StaffDataController {
	
	
	private StaffData dataModel;
	private Session sessionModel;
	private StaffDataView view;
	private ApplicationController application;
	
	
	public StaffDataController (ApplicationController app, StaffData data, Session session) {
		this.dataModel = data;
		this.sessionModel = session;
	}
	
	
	
	

	public void deleteItem(int selectedRow) {
		///TO-DO
	}

	public void setView(StaffDataView view) {
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
			int staffNo = (int)dataModel.getValueAt(selectedRow, 0);
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





	public void ShowStaff() {
		dataModel.readValue("Staff");
		this.view.setTableModel(dataModel);
		
	}





	public void ShowDepartment() {
		dataModel.readValue("Departments");
		this.view.setTableModel(dataModel);
		
	}
	
	public void ShowPatients() {
		dataModel.readValue("Patients");
		this.view.setTableModel(dataModel);
		
	}



	




	

}
