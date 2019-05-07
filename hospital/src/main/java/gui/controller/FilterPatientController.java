package gui.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.model.FilterPatientData;
import gui.model.Session;

import gui.views.FilterPatientView;
import hospital.Patient;

public class FilterPatientController {

	
	
	private Session sessionModel;
	private FilterPatientView view;
	private FilterPatientData data;

	public FilterPatientController(Session s,DataController c,FilterPatientData d){
		this.sessionModel=s;
		this.data=d;
		
	}
	
	public void setView(FilterPatientView view) {
		this.view = view;
		
	}
	

	public void display() {
		view.setVisible(true);
	}
	public void FilterPatientClicked(List<JTextField> txtEntries) {
		
		
		if(validateInput(txtEntries)) {
			showResults();
			data.FilterPatient( txtEntries);
			view.setVisible(false);
		}
		else {
			view.showError();
		}
		
		
	
	};
	
	private boolean validateInput(List<JTextField> txtEntries) {
		
		for (JTextField f : txtEntries) {
			if(!f.getText().isEmpty()) {return true;}
		}
		return false;
		
	}
	
	public void showResults() {
		JFrame results = new JFrame();
		results.setResizable(false);
		results.setTitle("Filter");
		results.setLayout(new BorderLayout());
		
		JTable tblData = new JTable();
		tblData.setModel(data);
		
		results.add(new JScrollPane(tblData), BorderLayout.CENTER);
		
		
		results.pack();
		results.setLocationRelativeTo(null);
		results.setVisible(true);
		
	}
	
}
