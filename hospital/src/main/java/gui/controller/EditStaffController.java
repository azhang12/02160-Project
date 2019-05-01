package gui.controller;

import java.util.List;

import javax.swing.JTextField;

import gui.model.Session;
import gui.views.EditStaffView;
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
	
	//User clicked the Add-Button
	public void addStaffClicked(List<JTextField> txtEntries) {
		if(validateInput(txtEntries)) {
		}
		else {
			view.showError();}
	}
		
	
		//Are all Values Correct?
	private boolean validateInput(List<JTextField> txtEntries) {
		for (JTextField f : txtEntries) {
			if(f.getText().isEmpty()) {return false;}
		}
		return true;
		
	}
	
	
	
	
}
