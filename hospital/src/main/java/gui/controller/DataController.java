package gui.controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hospital.Department;
import hospital.Finder;
import hospital.InpatientDepartment;
import hospital.OutpatientDepartment;
import hospital.Patient;
import hospital.Staff;
import hospital.Patient;
import hospital.System;
import gui.model.FilterStaffData;
import gui.model.FilterPatientData;
import gui.model.Session;
import gui.model.Data;
import gui.views.AddPatientView;
import gui.views.AddStaffView;
import gui.views.FilterStaffView;
import gui.views.FilterPatientView;
import gui.views.DataView;
import gui.views.EditPatientView;
import gui.views.EditStaffView;
import gui.views.EditPatientView;

public class DataController {
	
	
	private Data dataModel;
	private Session sessionModel;
	private DataView view;
	private ApplicationController application;
	
	
	public DataController (ApplicationController app, Data data, Session session) {
		this.dataModel = data;
		this.sessionModel = session;
	}
	
	public void deleteItem(int selectedRow) {
		///TO-DO
	}

	public void setView(DataView view, String data) {
		this.view = view;
		this.view.setTableModel(dataModel,data);
		this.view.setSession(sessionModel);
	}

	public void display() {
		view.setVisible(true);
	}
	
	public void AddClicked(String s) {
		
		if(s.equals("Department")) {
			
			String[] choices = new String[2];
			choices[0]= "Inpatient Department";
			choices[1]= "Outpatient Department";
			
		   	String newDep = (String)JOptionPane.showInputDialog(null, "Choose now...",
		        "What kind of Department...", JOptionPane.QUESTION_MESSAGE, null,
		        choices, // Array of choices
		        choices[0]); // Initial choice
		   	//Only if not closed
		   	if (newDep!=null) {
		   		String newDepName="";
			   	while(Finder.findDepartment(newDepName, dataModel.getData().getDepartment())!=null||newDepName.equals("")) {
		   			if(newDepName!=null) {
		   				newDepName = (String) JOptionPane.showInputDialog("Please enter Department Name:");
		   			}
		   		}
			   	if(newDep.equals(choices[0])){
			   		String bedNo="";
			   		int beds=0;
			   		while (beds<=0) {
			   			if(bedNo!=null){
			   				bedNo = (String) JOptionPane.showInputDialog("Please enter Number of Beds:");
				   			try {  
					            beds = Integer.parseInt(bedNo);
					         } catch (NumberFormatException e) {  
					        	
					         }  
			   			}
			   			
			   		}	
			   		//ADD INPATIENTDEPARTMENT
			   		dataModel.addDepartment(newDepName, beds);
			   		
			   	}
			   	else if(newDep.equals(choices[1])) {
			   		//Add outpatient Department
			   		dataModel.addDepartment(newDepName, 0);
			   		
			   	}
		   	}
		   	
		   
		   	
			
		}
		
		else if(s.equals("Patient")) {
			AddPatientController c = new AddPatientController(this);
			AddPatientView view = new AddPatientView(c);
			c.setView(view);
			view.setVisible(true);	
		}
		
		else if(s.equals("Staff")) {
			AddStaffController c = new AddStaffController(sessionModel,this);
			AddStaffView view = new AddStaffView(c);
			c.setView(view);
			view.setVisible(true);	
		}	
	}
	
	

	public void add(List<String> txtEntries,String whatData) {
		
		if(whatData.equals("Staff")) {
			dataModel.addStaff(txtEntries);
		}
		else if (whatData.equals("Patient")) {
			dataModel.addPatient(txtEntries);
		}
		
		else {
			view.showError();
		}	
	}


	public void DeletePersonClicked(String s, int selectedRow) {
		
		if (selectedRow >= 0) {
			if(s.equals("Staff")) {
				int staffNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
				dataModel.removeStaff(staffNo);
			}
			else if(s.equals("Patient")){
				int patNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
				dataModel.removePatient(patNo);
				
			}
			
		}
		else {
			view.showError("Please make selection!");
		}
		
	}



	public void FilterStaff(List<JTextField> txtEntries) {
		// TODO Auto-generated method stub
		
	}



	public void FilterClicked(String s) {
		if (s.equals("Patient")) {
			FilterPatientController c = new FilterPatientController(sessionModel,this,new FilterPatientData(dataModel.getData()));
			FilterPatientView view = new FilterPatientView(c);	
			c.setView(view);
			view.setVisible(true);
		} else if (s.equals("Staff")) {
			FilterStaffController c = new FilterStaffController(sessionModel,this,new FilterStaffData(dataModel.getData()));
			FilterStaffView view = new FilterStaffView(c);	
			c.setView(view);
			view.setVisible(true);
		}
		

		
	}

	public void ShowData(String s) {
		this.dataModel= new Data(dataModel.getData(),s,sessionModel);
		this.view.setTableModel(dataModel,s);
		
		
	}
	

	public void EditClicked(String s,int selectedRow) {
		if (selectedRow >= 0) {
			if(s.equals("Department")) {
						
			}
					
			else if(s.equals("Patient")) {
				Patient patient = Finder.findPatient(Integer.parseInt(dataModel.getValueAt(selectedRow, 0)), dataModel.getData().getPatient());

				EditPatientController c = new EditPatientController(sessionModel, this);
				EditPatientView view = new EditPatientView(c, patient);
				c.setView(view);
				view.setVisible(true);
			}
			
			else if(s.equals("Staff")) {
				Staff staff = Finder.findStaff(dataModel.getData().getStaff(), Integer.parseInt(dataModel.getValueAt(selectedRow, 0)));
				
				EditStaffController c = new EditStaffController(sessionModel,this);
				EditStaffView view = new EditStaffView(c,staff);
				c.setView(view);
				view.setVisible(true);
			}
		}
		else {
			view.showError("Please choose " +s + "!");
		}
		
	}

	public void exportData() {
		System.exportData(dataModel.getData());
		
	}

	

	public void closeWindow() {
		int input = JOptionPane.showConfirmDialog(null, "Do you want to save the changes?","Save...",JOptionPane.YES_NO_CANCEL_OPTION);
		
		if(input==0) {
			//Save&Close
			exportData();
			view.dispose();
		}
		else if(input==1) {
			//Do not save & Close
			view.dispose();
		}
		else if(input ==2) {
			//Do not save& do not close
			
		
	}

		
	}

	public void editStaffInfo(Staff staff, List<String> newValues) {
		
		dataModel.editStaff(staff, newValues);	
	}
	
	public void editPatientInfo(Patient patient, List<String> newValues) {
		dataModel.editPatient(patient, newValues);
	}


	public void PrintPdf() {
		if(System.printPDF(dataModel.getData())) {
			view.showSucces("Files successfully printed");
		}
		
	}

	public void AdmitPatientClicked(int selectedRow) {
		int patNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
		if(Finder.findPatient(patNo, dataModel.getData().getPatient()) != null) {
			if(Finder.findPatient(patNo, dataModel.getData().getPatient()).getDepartment()==null){
				String[] choices= new String[this.dataModel.getData().getDepartment().size()];
				for (int i=0; i<choices.length;++i) {
					choices[i] = this.dataModel.getData().getDepartment().get(i).getName();
				}
			    String newDepartment = (String) JOptionPane.showInputDialog(null, "Choose now...",
			        "Admit patient ...", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                        // default
			                                                                        // icon
			        choices, // Array of choices
			        choices[0]); // Initial choice
				
				
		        if(Finder.findDepartment(newDepartment, dataModel.getData().getDepartment())!=null){
		        	
		        	dataModel.admitPatient(patNo,newDepartment);
		        }
		        else {
		        	view.showError("Not such Department found");
		        }
			}
			else {
				view.showError("Patient already admitted. Please discharge firstly!");
			}
		
	        
		}
		else {
			view.showError("Please select Patient");
		}
		
		
	}

	public void DischargePatientClicked(int selectedRow) {
		if(selectedRow>-1){
			int patNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
			if((Finder.findPatient(patNo, dataModel.getData().getPatient()).getDepartment()!=null)){
				dataModel.dischargePatient(patNo);
				
			}
		}
		
		else {
			view.showError("Please select Patient");
		}
		
	}

	public void CallPatientClicked(int selectedRow) {
		if(selectedRow>-1) {
			int patNo = Integer.parseInt(dataModel.getValueAt(selectedRow, 0));
			Department dep = Finder.findDepartment(Finder.findPatient(patNo, dataModel.getData().getPatient()).getDepartment().getName(), dataModel.getData().getDepartment());
			if(dep instanceof InpatientDepartment&&Finder.findPatient(patNo,dataModel.getData().getPatient()).getBed()==null) {
				//Show Beds
				String[] beds= new String[((InpatientDepartment) dep).getBed().size()];
				for (int i=0; i<beds.length;++i) {
					beds[i] = (Integer.toString(((InpatientDepartment) dep).getBed().get(i).getId()));
				}
			   	String newBedId = (String)JOptionPane.showInputDialog(null, "Choose now...",
			        "Choose Bed ...", JOptionPane.QUESTION_MESSAGE, null,
			        beds, // Array of choices
			        beds[0]); // Initial choice
				
				int newId = Integer.parseInt(newBedId);
				dataModel.callPatient(selectedRow,newId);
			}
			else if(dep instanceof OutpatientDepartment) {
				if(Finder.findPatient(patNo,dataModel.getData().getPatient()).getQueueNumber()==1) {
					dataModel.callPatient(selectedRow,0);
				}
				else {
					view.showError("You are only allowed to call next Patient in Queue");
				}
			}
			else {
				view.showError("Patient already called!");
			}
			
			
			
		}
		else {
			view.showError("Please select Patient");
		}
		
	}

	public void ChangeDepartmentClicked(int selectedRow) {
		this.DischargePatientClicked(selectedRow);
		this.AdmitPatientClicked(selectedRow);
		
	}

	public void ChangeBedClicked(int selectedRow) {
		dataModel.changeBed(selectedRow);
		CallPatientClicked(selectedRow);
		
	}
	
	public Data getDataModel() {
		return this.dataModel;
	}
}
