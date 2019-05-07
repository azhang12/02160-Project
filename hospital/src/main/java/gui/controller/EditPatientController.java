package gui.controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import gui.model.Session;
import gui.views.EditPatientView;
import hospital.Patient;

public class EditPatientController {
	
	private Session sessionModel;
	private EditPatientView view;
	private DataController controller;
	
	
	// constructor
	public EditPatientController(Session s,DataController c){
		this.sessionModel = s;
		this.controller = c;
	}
	
	
	
	
	public void setView(EditPatientView view) {
		this.view = view;
	}
	
	
	
	public void display() {
		view.setVisible(true);
	}
	
	
	
	
	
	public void editPatientClicked(Patient patient, List<JTextField> txtEntries) {
		List<String> newValues = new ArrayList<String>();
		if(validateInput(txtEntries)) {
			if(txtEntries.get(0).getText().isEmpty()) {newValues.add(patient.getFirstName());}
			else {
				newValues.add(txtEntries.get(0).getText());
			}
			
			if(txtEntries.get(1).getText().isEmpty()) {newValues.add(patient.getLastName());}
			else {
				newValues.add(txtEntries.get(1).getText());
			}
			
			if(txtEntries.get(2).getText().isEmpty()) {newValues.add(patient.getBirthday());}
			else {
				newValues.add(txtEntries.get(2).getText());
			}
			
			if(txtEntries.get(3).getText().isEmpty()) {newValues.add(patient.getAddress());}
			else {
				newValues.add(txtEntries.get(3).getText());
			}
			
			if(txtEntries.get(4).getText().isEmpty()) {newValues.add(patient.getPhoneNumber());}
			else {
				newValues.add(txtEntries.get(4).getText());
			}
			
			if(txtEntries.get(5).getText().isEmpty()) {newValues.add(patient.getNationality());}
			else {
				newValues.add(txtEntries.get(5).getText());
			}
			
			String status;
			if(patient.getAlive()) {
				status = "Alive";
			} else {
				status = "Dead";
			}
			
			String newStatus = txtEntries.get(6).getText();
			
			if(txtEntries.get(6).getText().isEmpty()) {newValues.add(status);}
			else if((newStatus.equals("Alive")) || newStatus.equals("Dead")){
				newValues.add(newStatus);
			} else {
				newValues.add(status);

			}
			
			controller.editPatientInfo(patient,newValues);
			view.setVisible(false);
		}
		else {
			view.showError("Please add Information to change");}
	}
	
	
	
	private boolean validateInput(List<JTextField> txtEntries) {
		for (JTextField f : txtEntries) {
			if(!f.getText().isEmpty()) {return true;}
		}
		return false;
		
	}
}

/*

<<<<<<< HEAD
	
	private Session sessionModel;
	private EditPatientView view;
	private DataController controller;
	
	public EditPatientController(Session s, DataController c) {
		this.sessionModel = s;
		this.controller = c;
	}
	
	public void setView(EditPatientView view) {
		this.view = view;
	}
	
	public void display() {
		view.setVisible(true);
	}
	
	// User clicked the Save changes
	public void editPatientClicked(Patient patient, List<JTextField> txtEntries) {
		List<String> newValues = new ArrayList<String>();
		if(validateInput(txtEntries)) {
			if(txtEntries.get(0).getText().isEmpty()) {
				newValues.add(patient.getFirstName());
			} else {
				newValues.add(txtEntries.get(0).getText());
			}
			if(txtEntries.get(1).getText().isEmpty()) {
				newValues.add(patient.getLastName());
			} else {
				newValues.add(txtEntries.get(1).getText());
			}
			if(txtEntries.get(2).getText().isEmpty()) {
				newValues.add(patient.getBirthday());
			} else {
				newValues.add(txtEntries.get(2).getText());
			}
			if(txtEntries.get(3).getText().isEmpty()) {
				newValues.add(patient.getAddress());
			} else {
				newValues.add(txtEntries.get(3).getText());
			}
			if(txtEntries.get(4).getText().isEmpty()) {
				newValues.add(patient.getPhoneNumber());
			} else {
				newValues.add(txtEntries.get(4).getText());
			}
			if(txtEntries.get(5).getText().isEmpty()) {
				newValues.add(patient.getAlive().toString());
			} else {
				newValues.add(txtEntries.get(5).getText());
			}
			if(txtEntries.get(6).getText().isEmpty()) {
				newValues.add(patient.getNationality());
			} else {
				newValues.add(txtEntries.get(6).getText());
			}
			controller.editPatientInfo(patient, newValues);
			
		} else {
			view.showError("Please add information to edit");
		}
	}
		
		//Value input?
	private boolean validateInput(List<JTextField> txtEntries) {
		for (JTextField f : txtEntries) {
			if(!f.getText().isEmpty()) {return true;}
		}
		return false;
	
	}

=======
=======


>>>>>>> 98d06992b27d4fef91b7f8be39af2c53473bb837


	public void editPatientClose() {
		view.setVisible(false);
		
	}
<<<<<<< HEAD
>>>>>>> d0f45d519819b9a0900df3624b54b7ed4f5a802b
}
	
	*/


	
	
	
	

