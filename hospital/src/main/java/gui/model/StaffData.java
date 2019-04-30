package gui.model;

import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import hospital.Department;
import hospital.Finder;
import hospital.Hospital;
import hospital.Staff;
import hospital.System;

public class StaffData extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	private Hospital hospital;
	private String[][] DisplayedData;
	private String[] ColumnNames;
	private String whatData= "Staff";
	
	
	
	public StaffData() {
		
		hospital = new Hospital();
		
	}
	
	public StaffData(Hospital h) {
		this.hospital=h;
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
		return ColumnNames.length;
	}

	@Override
	public int getRowCount() {
		
		return DisplayedData.length;
	}
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String[] current = DisplayedData[rowIndex];
		
			for(int j=0; j<current.length;++j) {
				if(columnIndex==j)
				
				return current[j];
			}
		
		
		return null;
		
	}
	
	@Override
	public String getColumnName(int column) {
		for (int i=0; i<DisplayedData[0].length; ++i)
		{
			if (column == i) {
				return this.DisplayedData[0][i];
			} 
		}
		
		
		return null;
	}

	public void removeStaff(int staffNo) {

		int i = Finder.findStaff(hospital.getStaff(), staffNo);
		if(i>-1) {
			hospital.getStaff().remove(i);
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
		List<Department> dep = hospital.getDepartment();
		this.DisplayedData= new String[dep.size()+1][1];
		//ColumnNames
		this.DisplayedData[0]= new String [] {"Department"};
		
		for (int i=0; i<dep.size();++i) {
			this.DisplayedData[i+1]= new String [] {dep.get(i).getName()}; 
		}
		
	}

	private void setTableToPatients(Hospital data) {
		// TODO Auto-generated method stub
		
	}

	public void setTableToStaff(Hospital data) {
		List<Staff> staff = data.getStaff();
		this.DisplayedData= new String[staff.size()][6];
		//ColumnNames
		this.ColumnNames= new String [] {"ID","First Name", "Last Name", "Email", "Department", "JobRole"};
		
		for (int i=0; i<staff.size();++i) {
			this.DisplayedData[i]= new String [] {Integer.toString(staff.get(i).getStaffNumber()),staff.get(i).getFirstName(), staff.get(i).getLastName(), staff.get(i).getEmail(), staff.get(i).getDepartment().getName(), staff.get(i).getJobRole().toString()}; 
		}
		
	}
	
	
	
	

}
