package gui.controller;

import java.util.List;

import gui.model.Data;
import gui.model.Session;
import gui.model.User;
import gui.views.LoginView;
import gui.views.RegisterPatientView;
import javax.swing.JTextField;

public class RegisterController {

	
	
	private Session session;
	private RegisterPatientView view;
	
	public RegisterController(Session session) {
		
		this.session = session;
		this.view = new RegisterPatientView(this);
	}
	
	
	//Check Validity of input Data
	public void validateInput(List<JTextField> input) {
		
		for (JTextField item : input) {
			if(item.getText().isEmpty()) {
				view.showError();
				
			}
		}
		
			
	}
	
	
	public void display() {
		view.setVisible(true);
	}
}
