package gui.controller;

import java.util.List;

import javax.swing.JTextField;

import gui.model.Session;
import gui.views.AddStaffView;
public class AddStaffController {
	
	
	private Session sessionModel;
	private AddStaffView view;
	private DataController controller;

	public AddStaffController(Session s,DataController c){
		this.sessionModel=s;
		this.controller=c;
	}
	
	public void setView(AddStaffView view) {
		this.view = view;
	}

	public void display() {
		view.setVisible(true);
	}
	
	//User clicked the Add-Button
	public void addStaffClicked(List<String> entries, List<String> txtNames) {
		if(validateInput(entries, txtNames) == "") {
			controller.add(entries,"Staff");
			view.dispose();
		}
		else {
			view.showError(validateInput(entries, txtNames));}
	}
		
	
		//Are all Values Correct?
	private String validateInput(List<String> entries, List<String> txtNames) {
		String errMess = "";
		int errMessCount = 0;
		for (int i = 0; i < entries.size(); i++){
			if(entries.get(i) == null) {
				if (errMessCount > 0) {
					errMess += ", ";
				}
				
				errMess += txtNames.get(i);
				errMessCount += 1;
			}
		}
	
		
		if (errMessCount == 1) {
			errMess += " field is empty";
		} else if (errMessCount > 1) {
			errMess += " fields are empty";
		}
		
		return errMess;	
	}
	
	
	
	
}
