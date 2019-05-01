package hospital;

import java.util.List;
import java.util.ArrayList;

public class Hospital {

	//array lists
	private List<Staff> staffList = new ArrayList<Staff>();
	private List<Patient> patientList = new ArrayList<Patient>();
	private List<Department> departmentList = new ArrayList<Department>();
	

	//constructor
	public Hospital() {
		this.staffList = new ArrayList<Staff>();
		this.patientList = new ArrayList<Patient>();
		this.departmentList = new ArrayList<Department>();
		
	}
	public Hospital (List<Department> dep, List<Staff> s, List<Patient> p) {
		this.staffList = s;
		this.departmentList = dep;
		this.patientList = p;
	}
	
	//getters
	public List<Staff> getStaff() {
		return staffList;
	}
	public List<Patient> getPatient() {
		return patientList;
	}
	public List<Department> getDepartment() {
		return departmentList;
	}

	//Staff
	public void addStaff(Staff newStaff) {
		this.staffList.add(newStaff);
	}
	public void removeStaff(Staff rmStaff) {
		this.staffList.remove(rmStaff);
	}	
	
	//Patient
	public void addPatient(Patient newPatient, Department newDepartment) {
		this.patientList.add(newPatient);
		newDepartment.admitPatient(newPatient);
	}	
	public void removePatient(Patient rmPatient, Department department) {
		this.patientList.remove(rmPatient);
		department.dischargePatient(rmPatient);
	}
	public void movePatient(Patient patient, Bed newBed) {
		patient.setBed(newBed);
	}

	//Department
	public void addDepartment(Department newDepartment) {
		this.departmentList.add(newDepartment);
	}
	public void removeDepartment(Department rmDepartment) {
		this.departmentList.remove(rmDepartment);
	}
	
}
