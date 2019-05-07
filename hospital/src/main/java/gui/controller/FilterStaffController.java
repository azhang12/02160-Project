package gui.controller;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gui.model.FilterStaffData;
import gui.model.Session;

import gui.views.FilterStaffView;


public class FilterStaffController {
	
	
	private Session sessionModel;
	private FilterStaffView view;
	private FilterStaffData data;

	public FilterStaffController(Session s,DataController c,FilterStaffData d){
		this.sessionModel=s;
		this.data=d;
		
	}
	
	public void setView(FilterStaffView view) {
		this.view = view;
		
	}
	

	public void display() {
		view.setVisible(true);
	}
	public void FilterStaffClicked(List<JTextField> txtEntries) {
		
		
		if(validateInput(txtEntries)) {
			showResults();
			data.FilterStaff( txtEntries);
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
