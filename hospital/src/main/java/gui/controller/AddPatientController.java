package gui.controller;

import java.util.List;

import javax.swing.JTextField;

import gui.model.Session;
import gui.views.AddPatientView;
public class AddPatientController {
	
	

	private AddPatientView view;
	private DataController controller;

	public AddPatientController(DataController c){
		this.controller=c;
	}
	
	public void setView(AddPatientView view) {
		this.view = view;
	}

	public void display() {
		view.setVisible(true);
	}
	
	//User clicked the Add-Button
	public void addPatientClicked(List<JTextField> txtEntries) {
		if(validateInput(txtEntries)) {
			controller.add(txtEntries,"Patient");
		}
		else {
			view.showError();}
	}
		
	
		//Are all Values Correct?
	private boolean validateInput(List<JTextField> txtEntries) {
		for (JTextField f : txtEntries) {
			if(f.getText().isEmpty()) {return false;}
		}
		if(!txtEntries.get(5).getText().equals("yes") && !txtEntries.get(6).getText().equals("no")) {
			return false;
		}
		
		return true;
		
		
	}
	
	
	
	
}