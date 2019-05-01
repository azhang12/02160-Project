package hospital;

<<<<<<< HEAD

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;
import java.util.List;
=======
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;
>>>>>>> 33802a1fdef2ad6085e7b6d2391c2192ed463d84

public class Hospital {

	// array lists
	protected static ArrayList<Staff> staffList = new ArrayList<Staff>();
	protected static ArrayList<Patient> patientList = new ArrayList<Patient>();
	protected static ArrayList<Department> departmentList = new ArrayList<Department>();

	// constructor
	public Hospital() {
		this.staffList = new ArrayList<Staff>();
		this.patientList = new ArrayList<Patient>();
		this.departmentList = new ArrayList<Department>();

	}

<<<<<<< HEAD
	
	public Hospital (ArrayList<Department>dep, ArrayList<Staff> s, ArrayList<Patient>p) {
=======
	public Hospital(ArrayList<Department> dep, ArrayList<Staff> s, ArrayList<Patient> p) {
>>>>>>> 33802a1fdef2ad6085e7b6d2391c2192ed463d84

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

	// Department
	public void addDepartment(Department newDepartment) {
		this.departmentList.add(newDepartment);
	}

	public void removeDepartment(Department rmDepartment) {
		this.departmentList.remove(rmDepartment);
	}


	public static ArrayList<Staff> getStaff() {
		return staffList;
	}

	public static ArrayList<Patient> getPatient() {
		return patientList;
	}

	public static ArrayList<Department> getDepartment() {
		return departmentList;
	}


	public int getSize(ArrayList ArrayList) {
		return ArrayList.size();
	}
	public int getCntStaff(){
		return getSize(staffList);
	}
	public int getCntPatients() {
		return getSize(patientList);
	}
	public int getCntDepartments() {
		return getSize(departmentList);
	}


}
