package gui.controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.model.FilterStaffData;
import gui.model.Session;

import gui.views.FilterStaffView;

public class FilterStaffController {
	
	
	private Session sessionModel;
	private FilterStaffView view;
	private FilterStaffData data;

	public FilterStaffController(Session s,StaffDataController c,FilterStaffData d){
		this.sessionModel=s;
		this.data=d;
		
	}
	
	public void setView(FilterStaffView view) {
		this.view = view;
		
	}
	

	public void display() {
		view.setVisible(true);
	}
	public void FilterStaffClicked(List<JTextField> txtEntries) {
		
		if(validateInput(txtEntries)) {
			data.FilterStaff( txtEntries);
		}
		else {
			view.showError();
		}
		
		
	
	};
	
	private boolean validateInput(List<JTextField> txtEntries) {
		
		for (JTextField f : txtEntries) {
			if(!f.getText().isEmpty()) {return true;}
		}
		return false;
		
	}
	
	
	
	
}
