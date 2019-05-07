package gui.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import gui.model.Session;
import gui.views.EditStaffView;
import hospital.Staff;
public class EditStaffController {
	
	private Session sessionModel;
	private EditStaffView view;
	private DataController controller;

	public EditStaffController(Session s,DataController c){
		this.sessionModel=s;
		this.controller=c;
	}
	
	public void setView(EditStaffView view) {
		this.view = view;
	}

	public void display() {
		view.setVisible(true);
	}
	
	//User clicked the Save changes
	public void editStaffClicked(Staff staff, List<JTextField> txtEntries) {
		List<String> newValues = new ArrayList<String>();
		if(validateInput(txtEntries)) {
			if(txtEntries.get(0).getText().isEmpty()) {
				newValues.add(staff.getFirstName());
			}
			else {
				newValues.add(txtEntries.get(0).getText());
			}
			if(txtEntries.get(1).getText().isEmpty()) {newValues.add(staff.getLastName());}
			else {
				newValues.add(txtEntries.get(1).getText());
			}
			if(txtEntries.get(2).getText().isEmpty()) {newValues.add(staff.getDepartment().getName());}
			else {
				newValues.add(txtEntries.get(2).getText());
			}
			if(txtEntries.get(3).getText().isEmpty()) {newValues.add(staff.getJobRole().toString());}
			else {
				newValues.add(txtEntries.get(3).getText());
			}
			controller.editStaffInfo(staff,newValues);
		}
		else {
			view.showError("Please add Information to change");}
	}
		
	
		//Value input?
	private boolean validateInput(List<JTextField> txtEntries) {
		for (JTextField f : txtEntries) {
			if(!f.getText().isEmpty()) {return true;}
		}
		return false;
		
	}
	
	
	
	
}
