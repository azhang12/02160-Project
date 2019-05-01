package hospital;

<<<<<<< HEAD
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

=======
import java.util.List;
>>>>>>> branch 'master' of https://github.com/azhang12/02160-Project.git
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
<<<<<<< HEAD
	
	public Hospital (ArrayList<Department>dep, ArrayList<Staff> s, ArrayList<Patient>p) {
=======
	public Hospital (List<Department> dep, List<Staff> s, List<Patient> p) {
>>>>>>> branch 'master' of https://github.com/azhang12/02160-Project.git
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
<<<<<<< HEAD
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
=======
>>>>>>> branch 'master' of https://github.com/azhang12/02160-Project.git
	
}
