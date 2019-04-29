package gui.model;

import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import hospital.Finder;
import hospital.Hospital;
import hospital.Staff;
import hospital.System;

public class StaffData extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	private Hospital hospital;
	
	
	public StaffData() {
		
		hospital = new Hospital();
		
	}
	
	public StaffData(Hospital h) {
		this.hospital=h;
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
				
		fireTableDataChanged(); // notify the views that data changed
	}

	@Override
	public int getColumnCount() {
		return 6; // this is fixed to all Properties we show
	}

	@Override
	public int getRowCount() {
		List<Staff> s = hospital.getStaff();
		for (Staff ss : s)
		{	
			//this.addRow(new Object[] {"Hi","Hello"});
			
		}
		return hospital.getStaff().size();
	}
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Staff s = (Staff)hospital.getStaff().get(rowIndex);
		
		if (columnIndex == 0) {
			return s.getStaffNumber();
		} 
		else if (columnIndex == 1) {
			return s.getFirstName();
		}
		else if (columnIndex == 2) {
			return s.getLastName();
		}
		else if (columnIndex == 3) {
			return s.getEmail();
		}
		else if (columnIndex == 4) {
			return s.getDepartment();
		}
		else if (columnIndex == 5) {
			return s.getJobRole();
		}
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Id";
		} 
		else if (column == 1) {
			return "First Name";
		}
		else if (column == 2) {
			return "Last Name";
		}
		else if (column == 3) {
			return "Email";
		}
		
		else if (column == 4) {
			return "Department";
		}
		else if (column == 5) {
			return "Jobrole";
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
	
	
	
	

}
