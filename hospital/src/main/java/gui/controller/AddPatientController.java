package gui.controller;

<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.lang.reflect.Array;
import java.util.Arrays;
>>>>>>> 82063b302637302149fef8b980eb7e6d7562aa98
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
		// Added these lines below to get rid of the error
		List<String> tempList = Arrays.asList();				//
		if(validateInput(txtEntries)) {
<<<<<<< HEAD
			List<String> strings = new ArrayList<String>();
			for(JTextField t : txtEntries) {
				strings.add(t.getText());
			}
			controller.add(strings,"Patient");
=======
			for(JTextField tF : txtEntries) {					//
				String t = tF.getText();						//
				tempList.add(t);								//
			}													//
			controller.add(tempList,"Patient");					// tempList was txtEntries
>>>>>>> 82063b302637302149fef8b980eb7e6d7562aa98
		}
		else {
			view.showError();}
	}
		
	
		//Are all Values Correct?
	private boolean validateInput(List<JTextField> txtEntries) {
		
		for (JTextField f : txtEntries) {
			if(f.getText().isEmpty()) {return false;}
		}
		if(!txtEntries.get(5).getText().equals("yes") && !txtEntries.get(5).getText().equals("no")) {
			return false;
		}
		
		return true;
		
		
	}
	
	
	
	
}
