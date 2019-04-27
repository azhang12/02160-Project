package gui.controller;

import java.util.List;

import gui.model.Session;
import gui.model.User;
import gui.views.LoginView;
import gui.views.RegisterPatientView;
import javax.swing.JTextField;

public class RegisterController {

	
	private ApplicationController application;
	private Session session;
	private RegisterPatientView view;
	
	public RegisterController(ApplicationController application) {
		this.application = application;
		this.session = new Session();
		this.view = new RegisterPatientView(this);
	}
	
	
	//Check Validity of input Data
	public boolean validateInput(List<JTextField> input) {
		
		for (JTextField item : input) {
			if(item.getText().isEmpty()) {
				view.showError();
				return false;
			}
		}
		return true;
			
	}

	public void display() {
		view.setVisible(true);
	}
}
