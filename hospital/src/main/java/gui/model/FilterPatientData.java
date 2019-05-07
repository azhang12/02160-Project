package gui.model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import hospital.Finder;
import hospital.Hospital;
import hospital.Patient;

public class FilterPatientData extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	private List<Patient> patient;
	
	public FilterPatientData(Hospital hospital) {
		this.patient= new ArrayList<Patient>();
		List<Patient> p = hospital.getPatient();
		for (Patient i : p) {
			patient.add(i.copy());
		}
		
	}
	
	public List <Patient> getData()
	{ return this.patient;}
	
	

	@Override
	public int getColumnCount() {
		return 11; // this is fixed to all Properties we show
	}

	@Override
	public int getRowCount() {
		
		return patient.size();
	}
	
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Patient p = (Patient)patient.get(rowIndex);
		
		if (columnIndex == 0) {
			return p.getPatientNumber();
		} 
		else if (columnIndex == 1) {
			return p.getFirstName();
		}
		else if (columnIndex == 2) {
			return p.getLastName();
		}
		else if (columnIndex == 3) {
			return p.getDepartment();
		}
		else if (columnIndex == 4) {
			return p.getBirthday();
		}
		else if (columnIndex == 5) {
			return p.getAddress();
		}
		else if (columnIndex == 6) {
			return p.getPhoneNumber();
		}
		else if (columnIndex == 7) {
			return p.getAlive();
		}
		else if (columnIndex == 8) {
			return p.getNationality();
		}
		else if (columnIndex == 9) {
			return p.getBed();
		}
		else if (columnIndex == 10) {
			return p.getQueueNumber();
		}
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} 
		else if (column == 1) {
			return "First Name";
		}
		else if (column == 2) {
			return "Last Name";
		}
		else if (column == 3) {
			return "Department";
		}
		
		else if (column == 4) {
			return "Birthday";
		}
		else if (column == 5) {
			return "Address";
		}
		else if (column == 6) {
			return "Phone Number";
		}
		else if (column == 7) {
			return "Alive";
		}
		else if (column == 8) {
			return "Nationality";
		}
		else if (column == 9) {
			return "Bed No.";
		}
		else if (column == 10) {
			return "Queue No.";
		}
		
		return null;
	}

	public void removePatient(int patNo) {

		int i = Finder.findPatientInt(patient, patNo);
		if(i>-1) {
			patient.remove(i);
			fireTableDataChanged();
		}	
	}

	public  void FilterPatient(List<JTextField> txtEntries) {
		
		int s= patient.size();
		for (int i = s-1; i>-1;i--) {
			//filter by StaffNumber
			if(!txtEntries.get(0).getText().isEmpty()) {
				if (Integer.parseInt(txtEntries.get(0).getText())!=patient.get(i).getPatientNumber()){
					patient.remove(i);
				}
			}
			
			//Filter by FirstName
			if(!txtEntries.get(1).getText().isEmpty()) {
				if (!txtEntries.get(1).getText().equalsIgnoreCase(patient.get(i).getFirstName())){
					patient.remove(i);
				}
			}
			
			if(!txtEntries.get(2).getText().isEmpty()) {
				if (!txtEntries.get(2).getText().equalsIgnoreCase(patient.get(i).getLastName())){
					patient.remove(i);
				}
			}
			
			if(!txtEntries.get(3).getText().isEmpty()) {
				if (!txtEntries.get(3).getText().equalsIgnoreCase(patient.get(i).getDepartment().getName())){
					patient.remove(i);
				}
			}
			if(!txtEntries.get(4).getText().isEmpty()) {
				if (!txtEntries.get(4).getText().equalsIgnoreCase(patient.get(i).getBirthday().toString())){
					patient.remove(i);
				}
			}
			if(!txtEntries.get(5).getText().isEmpty()) {
				if (!txtEntries.get(5).getText().equalsIgnoreCase(patient.get(i).getAddress())){
					patient.remove(i);
				}
			}
			if(!txtEntries.get(6).getText().isEmpty()) {
				if (!txtEntries.get(6).getText().equalsIgnoreCase(patient.get(i).getPhoneNumber())){
					patient.remove(i);
				}
			}
			if(!txtEntries.get(7).getText().isEmpty()) {
				if (!txtEntries.get(7).getText().equalsIgnoreCase(patient.get(i).getAlive().toString())){
					patient.remove(i);
				}
			}
			if(!txtEntries.get(8).getText().isEmpty()) {
				if (!txtEntries.get(8).getText().equalsIgnoreCase(patient.get(i).getNationality())){
					patient.remove(i);
				}
			}
			if(!txtEntries.get(9).getText().isEmpty()) {
				if (!txtEntries.get(9).getText().equalsIgnoreCase(Integer.toString(patient.get(i).getBed().getId()))){
					patient.remove(i);
				}
			}
			if(!txtEntries.get(10).getText().isEmpty()) {
				if (!txtEntries.get(10).getText().equalsIgnoreCase(Integer.toString(patient.get(i).getQueueNumber()))){
					patient.remove(i);
				}
			}

		}
		fireTableDataChanged();	
	}

}
