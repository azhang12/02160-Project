package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import hospital.Department;
import hospital.Finder;
import hospital.Hospital;
import hospital.Patient;
import hospital.Staff;
import hospital.System;

public class StaffData extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	private Hospital hospital;
	private String whatData;
	private List<String>  ColumnNames= new ArrayList<String>();
	private List<List<String>>  DisplayedData = new ArrayList<List<String>>();
	
	
	public StaffData() {
		
		hospital = new Hospital();
		this.whatData="Staff";
		
	}
	
	public StaffData(Hospital h, String d) {
		this.hospital=h;
		this.whatData = d;
		readValue( whatData);
	}
	
	
	public Hospital getData()
	{ return this.hospital;}
	
	public void addStaff(List<JTextField> txtEntries) {
		
		
		String firstName = (txtEntries.get(0).getText());
		String lastName = (txtEntries.get(1).getText());
		String departmentName = (txtEntries.get(2).getText());
		String jobRole = (txtEntries.get(3).getText());
		
		
		
		if (System.registerStaff(hospital, firstName, lastName, jobRole, departmentName)) {
			
		}
		readValue(whatData);
		fireTableDataChanged(); // notify the views that data changed
	}

	@Override
	public int getColumnCount() {
		return ColumnNames.size();
	}

	@Override
	public int getRowCount() {
		
		return DisplayedData.size();
	}
	
	

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		List<String> current = DisplayedData.get(rowIndex);
		
			for(int j=0; j<current.size();++j) {
				if(columnIndex==j)
				
				return current.get(j);
			}
		
		
		return null;
		
	}
	
	@Override
	public String getColumnName(int column) {
		for (int i=0; i<ColumnNames.size(); ++i)
		{
			if (column == i) {
				return this.ColumnNames.get(i);
			} 
		}
		
		
		return null;
	}

	public void removeStaff(int staffNo) {

		int i = Finder.findStaff(hospital.getStaff(), staffNo);
		if(i>-1) {
			hospital.getStaff().remove(i);
			readValue(whatData);
			fireTableDataChanged();
		}
		
		
	}
	
	public void readValue(String what) {
		
		this.whatData=what;
		if(what=="Staff") {setTableToStaff(hospital);}
		else if (what=="Patients") {setTableToPatients(hospital);}
		else if (what=="Departments") {setTableToDepartments(hospital);}
	}
	
	private void setTableToDepartments(Hospital data) {
		DisplayedData.clear();
		ColumnNames.clear();
		List<Department> dep = hospital.getDepartment();
		//ColumnNames
		this.ColumnNames.add("Departments");
		
		for (int i=0; i<dep.size();++i) {
			List<String> newList = new ArrayList<String>();
			newList.add(dep.get(i).getName());
			this.DisplayedData.add(newList);
		}
		
	}

	private void setTableToPatients(Hospital data) {
		//FirstName,LastName,Department,Birthday,Address,phoneNumber,Alive,patientNumber,Nationality,bedNumber,queueNumber
		DisplayedData.clear();
		ColumnNames.clear();
		List<Patient> patients = data.getPatient();
		//ColumnNames
		this.ColumnNames.add("ID");
		this.ColumnNames.add("First Name");
		this.ColumnNames.add("Last Name");
		this.ColumnNames.add("Department");
		this.ColumnNames.add("Birthday");
		this.ColumnNames.add("Address");
		this.ColumnNames.add("PhoneNumber");
		this.ColumnNames.add("Alive");
		this.ColumnNames.add("Nationality");
		this.ColumnNames.add("Bed. No.");
		this.ColumnNames.add("Queue No.");
		
		
		//DOES NOT WORK IF THE INFO IS NULL
		for (int i=0; i<patients.size();++i) {
			List<String> d = new ArrayList<String>();
			d.add(Integer.toString(patients.get(i).getPatientNumber()));
			d.add(patients.get(i).getFirstName());
			d.add(patients.get(i).getLastName());
			if(patients.get(i).getDepartment()!=null) {
				d.add(patients.get(i).getDepartment().getName());
			}
			else {d.add("");}
			d.add(patients.get(i).getBirthday());
			d.add(patients.get(i).getAddress());
			d.add(patients.get(i).getPhoneNumber());
			d.add(patients.get(i).getAlive().toString());
			d.add(patients.get(i).getNationality());
			if(patients.get(i).getBed()!=null) {
				d.add(Integer.toString(patients.get(i).getBed().getId()));
			}
			else {d.add("");}
			if(patients.get(i).getQueueNumber()!=0) {
				d.add(Integer.toString(patients.get(i).getQueueNumber()));
			}
			else {d.add("");}
		
			
			///ADD Further Info
			
			DisplayedData.add(d);
			}
		
	}

	public void setTableToStaff(Hospital data) {
		DisplayedData.clear();
		ColumnNames.clear();
		List<Staff> staff = data.getStaff();
		//ColumnNames
		this.ColumnNames.add("ID");
		this.ColumnNames.add("First Name");
		this.ColumnNames.add("Last Name");
		this.ColumnNames.add("Email");
		this.ColumnNames.add("Department");
		this.ColumnNames.add("JobRole");
		
		for (int i=0; i<staff.size();++i) {
			List<String> d = new ArrayList<String>();
			d.add(Integer.toString(staff.get(i).getStaffNumber()));
			d.add(staff.get(i).getFirstName());
			d.add(staff.get(i).getLastName());
			d.add(staff.get(i).getEmail());
			d.add(staff.get(i).getDepartment().getName());
			d.add(staff.get(i).getJobRole().toString());
			DisplayedData.add(d);
		}
		
	}
	
	
	
	

}
