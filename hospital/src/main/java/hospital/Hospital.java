package hospital;
// comment
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;

public class Hospital {

	// array lists
	protected static ArrayList<Staff> staffList = new ArrayList<Staff>();
	protected static ArrayList<Patient> patientList = new ArrayList<Patient>();
	protected static ArrayList<Department> departmentList = new ArrayList<Department>();

	// constructor
	public Hospital() {
		
		this.departmentList = new ArrayList<Department>();
		this.staffList = new ArrayList<Staff>();
		this.patientList = new ArrayList<Patient>();
		

	}

	
	public Hospital(ArrayList<Department> dep, ArrayList<Staff> s, ArrayList<Patient> p) {

		this.staffList = s;
		this.departmentList = dep;
		this.patientList = p;
	}

	// Staff
	public void addStaff(Staff newStaff) {
		this.staffList.add(newStaff);
	}

	public void removeStaff(Staff rmStaff) {
		this.staffList.remove(rmStaff);
	}

	// Patient
	public void addPatient(Patient newPatient) {
		this.patientList.add(newPatient);
		
	}
	
	

	public void removePatient(Patient rmPatient, Department department) {
		this.patientList.remove(rmPatient);
		department.dischargePatient(rmPatient);
	}

	public void movePatient(Patient patient, Bed newBed) {
		patient.setBed(newBed);
	}

	// Department
	public void addDepartment(Department newDepartment) {
		this.departmentList.add(newDepartment);
	}

	public void removeDepartment(Department rmDepartment) {
		this.departmentList.remove(rmDepartment);
	}

	// getters
	public  ArrayList<Staff> getStaff() {
		return staffList;
	}

	public ArrayList<Patient> getPatient() {
		return patientList;
	}

	public static ArrayList<Department> getDepartment() {
		return departmentList;
	}


	
}
