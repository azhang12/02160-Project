package gui.controller;

import javax.swing.JOptionPane;

import gui.model.Data;
import gui.model.Session;
import gui.views.DataView;

public class DataController {
	
	private Data dataModel;
	private Session sessionModel;
	private DataView view;
	private ApplicationController application;
	
	
	public DataController (ApplicationController app, Data data, Session session) {
		this.dataModel = data;
		this.sessionModel = session;
	}
	
	public void register() {
		RegisterController regController = new RegisterController(sessionModel);
		regController.display();
	}

	public void deleteItem(int selectedRow) {
		///TO-DO
	}

	public void setView(DataView view) {
		this.view = view;
		this.view.setTableModel(dataModel);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}

}
