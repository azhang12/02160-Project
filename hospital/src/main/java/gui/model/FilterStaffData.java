package gui.model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import hospital.Finder;
import hospital.Hospital;
import hospital.Staff;

public class FilterStaffData extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	private List<Staff> staff;
	
	
	public FilterStaffData(Hospital hospital) {
		this.staff= new ArrayList<Staff>();
		List<Staff> s = hospital.getStaff();
		for (Staff i : s) {
			staff.add(i.copy());
		}
		
	}
	
	
	
	
	public List<Staff> getData()
	{ return this.staff;}
	
	

	@Override
	public int getColumnCount() {
		return 6; // this is fixed to all Properties we show
	}

	@Override
	public int getRowCount() {
		
		return staff.size();
	}
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Staff s = (Staff)staff.get(rowIndex);
		
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

		int i = Finder.findStaff(staff, staffNo);
		if(i>-1) {
			staff.remove(i);
			fireTableDataChanged();
		}
		
		
	}




	public void FilterStaff(List<JTextField> txtEntries) {
		
		
	}
	
	
	
	

}
