package gui.controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.model.Session;
import gui.views.AddStaffView;
import gui.views.StaffDataView;
import hospital.Staff;
public class AddStaffController {
	
	
	private Session sessionModel;
	private AddStaffView view;
	private StaffDataController controller;

	public AddStaffController(Session s,StaffDataController c){
		this.sessionModel=s;
		this.controller=c;
		
	}
	
	public void setView(AddStaffView view) {
		this.view = view;
		
	}

	public void display() {
		view.setVisible(true);
	}
	public void addStaffClicked(List<JTextField> txtEntries) {
		
		if(validateInput(txtEntries)) {
			controller.addPerson( txtEntries);
		}
		else {
			view.showError();
		}
		
		
	
	};
	
	private boolean validateInput(List<JTextField> txtEntries) {
		for (JTextField f : txtEntries) {
			if(f.getText().isEmpty()) {return false;}
		}
		return true;
		
	}
	
	
	
	
}
