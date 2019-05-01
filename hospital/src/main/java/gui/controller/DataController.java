package gui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hospital.Finder;
import hospital.Staff;
import hospital.System;
import gui.model.FilterStaffData;
import gui.model.Session;
import gui.model.Data;
import gui.views.AddStaffView;
import gui.views.FilterStaffView;
import gui.views.DataView;
import gui.views.EditStaffView;

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

	public void setView(DataView view, String data) {
		this.view = view;
		this.view.setTableModel(dataModel,data);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}
	
	public void AddPersonClicked(String s) {
		
		if(s.equals("Department")) {
			
		}
		
		else if(s.equals("Patient")) {
			
		}
		
		else if(s.equals("Staff")) {
			AddStaffController c = new AddStaffController(sessionModel,this);
			AddStaffView view = new AddStaffView(c);
			c.setView(view);
			view.setVisible(true);
			
		}
		
	}
	
	

	public void add(List<JTextField> txtEntries,String whatData) {
		
		if(whatData.equals("Staff")) {
			dataModel.addStaff(txtEntries);
		}
		else if (whatData.equals("Patient")) {
			dataModel.addPatient(txtEntries);
		}
		else if (whatData.equals("Department")) {
			dataModel.addDepartment(txtEntries);
		}
		else {
			view.showError();
		}
			
			
	}


	public void DeletePersonClicked(String s, int selectedRow) {
		
		if (selectedRow >= 0) {
			if(s.equals("Staff")) {
				int staffNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
				dataModel.removeStaff(staffNo);
			}
			else if(s.equals("Patient")){
				int patNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
				dataModel.removePatient(patNo);
				
			}
					
			
			
		}
		else {
			view.showError("Please make selection!");
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
		this.view.setTableModel(dataModel,s);
		
		
	}
	

	public void EditClicked(String s,int selectedRow) {
		if (selectedRow >= 0) {
			if(s.equals("Department")) {
						
			}
					
			else if(s.equals("Patient")) {
				
			}
			
			else if(s.equals("Staff")) {
				Staff staff = Finder.findStaff(dataModel.getData().getStaff(), Integer.parseInt(dataModel.getValueAt(selectedRow, 0)));
				
				EditStaffController c = new EditStaffController(sessionModel,this);
				EditStaffView view = new EditStaffView(c,staff);
				c.setView(view);
				view.setVisible(true);
			}
		}
		else {
			view.showError("Please choose " +s + "!");
		}
		
	}

	public void exportData() {
		System.exportData(dataModel.getData());
		
	}

	

	public void closeWindow() {
		int input = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?","Save...",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(input==0) {
			//Save&Close
			exportData();
			view.dispose();
		}
		else if(input==1) {
			//Do not save & Close
			view.dispose();
		}
		else if(input ==2) {
			//Do not save& do not close
			
		
	}

		
	}

	public void editStaffInfo(Staff staff, List<String> newValues) {
		
		dataModel.editStaff(staff, newValues);	
	}

	public void PrintPdf() {
		if(System.printPDF(dataModel.getData())) {
			view.showSucces("Files successfully printed");
		}
		
	}

	

	

}
