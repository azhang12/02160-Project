package gui.controller;

import java.util.List;

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
		String testing = "";
		testing = validateInput(entries, txtNames);
		if(testing == "") {
			controller.add(entries,"Staff");
			view.dispose();
		}
		else {
			view.showError(validateInput(entries, txtNames));
			view.dispose(); // ONLY disposing here because the error values persist while it is still open
			}
	}
		
	
		//Are all Values Correct?
	private String validateInput(List<String> entries, List<String> txtNames) {
		String errMess = "";
		int errMessCount = 0;
		for (int i = 0; i < 2; ++i){
			if(entries.get(i).isEmpty()) {
				errMess += "\n - " + txtNames.get(i);
				errMessCount += 1;
			}
		}
		for (int i = 2; i < 4; ++i) {
			if(entries.get(i) == "Make selection") {
				errMess += "\n - " + txtNames.get(i);
				errMessCount += 1;
			}
		}

		String finalMess = "";
		if (errMessCount > 0) {
			finalMess = "The following fields are empty: " + errMess;
		}
		return finalMess;	
		
	
	}
	
	
	
	
}
