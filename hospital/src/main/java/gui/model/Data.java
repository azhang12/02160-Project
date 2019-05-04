package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import hospital.Department;
import hospital.Finder;
import hospital.Hospital;
import hospital.InpatientDepartment;
import hospital.OutpatientDepartment;
import hospital.Patient;
import hospital.Staff;
import hospital.System;

public class Data extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	public static Hospital hospital;
	private String whatData;
	private List<String>  ColumnNames= new ArrayList<String>();
	private List<List<String>>  DisplayedData = new ArrayList<List<String>>();
	
	
	public Data() {
		
		hospital = new Hospital();
		this.whatData="Staff";
		
	}
	
	public Data(Hospital h, String d) {
		this.hospital=h;
		this.whatData = d;
		readValue( whatData);
	}
	
	
	public Hospital getData()
	{ return this.hospital;}
	
	

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

	
	
	public void readValue(String what) {
		
		this.whatData=what;
		if(what=="Staff") {setTableToStaff(hospital);}
		else if (what=="Patients") {setTableToPatients(hospital);}
		else if (what=="Departments") {setTableToDepartments(hospital);}
	}
	
	public void setTableToDepartments(Hospital data) {
		DisplayedData.clear();
		ColumnNames.clear();
		List<Department> dep = hospital.getDepartment();
		//ColumnNames
		this.ColumnNames.add("Departments");
		this.ColumnNames.add("No. of Beds");
		this.ColumnNames.add("Beds available");
		this.ColumnNames.add("Beds occupied");
		this.ColumnNames.add("Patients waiting");
		
		for (int i=0; i<dep.size();++i) {
			List<String> newList = new ArrayList<String>();
			newList.add(dep.get(i).getName());
			if(dep.get(i).getClass()==new InpatientDepartment("",0).getClass()) {
				InpatientDepartment current = (InpatientDepartment)dep.get(i);
				if(current.getBed()!=null) {
					int bedsTotal= current.getBed().size();
					newList.add(Integer.toString(bedsTotal));
					//Beds available
					int bedsOcc = current.occupiedBeds();
					int bedsAvailable = bedsTotal-bedsOcc;
					newList.add(Integer.toString(bedsAvailable));
					newList.add(Integer.toString(bedsOcc));
					newList.add("0");
				}
				else {
					newList.add("0");
					newList.add("0");
					newList.add("0");
					OutpatientDepartment current1 = (OutpatientDepartment)dep.get(i);
					if (current1.getQueue()!=null) {
						newList.add(Integer.toString(current1.getQueue().size()));
					}
					else {newList.add("0");}
				}
				
				
				
			}
			
			else if(dep.get(i).getClass()==new OutpatientDepartment("").getClass()) {
				OutpatientDepartment current = (OutpatientDepartment)dep.get(i);
				newList.add("0");
				newList.add("0");
				newList.add("0");
				if(current.getQueue()!=null) {
					newList.add(Integer.toString(current.getQueue().size()));
				}
				else {newList.add("0");
				
				}
			}
			
			
			
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
	public void addStaff(List<String> txtEntries) {	
			
			String firstName = (txtEntries.get(0));
			String lastName = (txtEntries.get(1));
			String departmentName = (txtEntries.get(2));
			String jobRole = (txtEntries.get(3));
			if (System.registerStaff(hospital, firstName, lastName, jobRole, departmentName)) {
				
			}
			readValue(whatData);
			fireTableDataChanged(); // notify the views that data changed
		}

	public void addPatient(List<String> txtEntries) {
		
		
		String firstName = (txtEntries.get(0));
		String lastName = (txtEntries.get(1));
		String dob = (txtEntries.get(2));
		String address = (txtEntries.get(3));
		String phone = (txtEntries.get(4));
		String alive = (txtEntries.get(5));
		String nation= (txtEntries.get(6));
		
		boolean aliveBool =true;
		if(alive.equals("no")) {aliveBool=false;}
		
		if (System.registerPatient(hospital, firstName, lastName,dob,address,phone,aliveBool,nation)) {
			
		}
		readValue(whatData);
		fireTableDataChanged(); // notify the views that data changed
			
		
	}

	public void addDepartment(List<String> txtEntries) {
		// TODO Auto-generated method stub
		
	}

	public void editStaff(Staff staff, List<String> newValues) {
		
		if (System.editStaff(hospital,staff, newValues.get(0),newValues.get(1),newValues.get(2),newValues.get(3))) {
			
		}
		readValue(whatData);
		fireTableDataChanged(); // notify the views that data changed
		
		
	}
	public void editPatient(List<JTextField> txtEntries) {
		// TODO Auto-generated method stub
		
	}
	public void editDepartment(List<JTextField> txtEntries) {
		// TODO Auto-generated method stub
		
	}

	public void removePatient(int patNo) {
		// TODO Auto-generated method stub
		
		
	}
	public void removeStaff(int staffNo) {

		int i = Finder.findStaffInt(hospital.getStaff(), staffNo);
		if(i>-1) {
			hospital.getStaff().remove(i);
			readValue(whatData);
			fireTableDataChanged();
		}
		
		
	}

	public void removeDepartment(String depName) {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	
	
	

}
