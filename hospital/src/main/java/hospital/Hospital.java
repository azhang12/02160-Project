package hospital;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

import java.util.ArrayList;



public class Hospital {

	//array lists
	protected static ArrayList<Staff> staffList = new ArrayList<Staff>();
	protected static ArrayList<Patient> patientList = new ArrayList<Patient>();
	protected static ArrayList<Department> departmentList = new ArrayList<Department>();
	

	//constructor
	public Hospital() {
		this.staffList = new ArrayList<Staff>();
		this.patientList = new ArrayList<Patient>();
		this.departmentList = new ArrayList<Department>();
		
	}
	
	public Hospital (ArrayList<Department>dep, ArrayList<Staff> s, ArrayList<Patient>p) {
		this.staffList = s;
		this.departmentList=dep;
		this.patientList=p;
		
		//Add Patients to Departments
		
		
	}
	
	
	
	//modifying lists of Staff, Patients, and Departments
	public void addStaff(Staff newStaff) {
		this.staffList.add(newStaff);
	}
	/*
	public void removeStaff(Staff rmStaff) {
		this.staffList.remove(rmStaff);
	}
	public void removeStaff(String rmStaffNo) {
		Iterator iter = staffList.iterator();
		while(iter.hasNext()) {
			Staff rmStaff = (Staff) iter.next();
			if(rmStaff.staffNumber == rmStaffNo) {
				staffList.remove(rmStaff); 
				break;
			}
		}
	}
	
	public void addPatient(Patient newPatient) {
		this.patientList.add(newPatient);
	}	
	public void removePatient(Patient rmPatient) {
		this.patientList.remove(rmPatient);
	}
	public void removePatient(String rmPatientNo) {
		Iterator iter = patientList.iterator();
		while(iter.hasNext()) {
			Patient rmPatient = (Patient) iter.next();
			if(rmPatient.patientNumber == rmPatientNo) {
				patientList.remove(rmPatient); //
				break;
			}
		}
	}
	
	public void movePatient(Patient patient, Bed newBed) {
<<<<<<< HEAD
		patient.setBed(newBed);
	}
		
=======
		patient.Bed = newBed;
	} //??
		*/

	public void addDepartment(Department newDepartment) {
		this.departmentList.add(newDepartment);
	}
	public void removeDepartment(Department rmDepartment) {
		this.departmentList.remove(rmDepartment);
	}
	//getters
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
	
	/*
	@Override
	public String toString() {
		return cntStaff + " staff, " + cntPatients + "patients, " 
	+ cntDepartments + "departments in this hospital." 
	}
	*/
	

}
