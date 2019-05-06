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

	

	// getters
	public  ArrayList<Staff> getStaff() {
		return staffList;
	}

	public  ArrayList<Patient> getPatient() {
		return patientList;
	}

	public static ArrayList<Department> getDepartment() {
		return departmentList;
	}


	
}
