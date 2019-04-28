package hospital;
import java.util.ArrayList;
import java.util.List;

public class Department {
	
	protected String name;
	
	public String getName() {return this.name;}
	
	protected ArrayList<Staff> staff = new ArrayList<Staff>();
	
	protected ArrayList<Patient> admittedPatients = new ArrayList<Patient>();
	
	// Constructor
	Department(){}
	Department(String Name){this.name = Name;}
	
	public boolean admitPatient(Patient newPatient) {
		return this.admittedPatients.add(newPatient);
	}
	
	public boolean dischargePatient(Patient patient) {
		return this.admittedPatients.remove(patient);
	}
	
	public void addStaff(Staff newStaff) {
		 this.staff.add(newStaff);
	}
	
	public boolean removeStaff(Staff staff) {
		return this.staff.remove(staff);
	}
	
	public ArrayList<Staff> getStaff() {
		return staff;
	}
	
	public ArrayList<Patient> getPatients() {
		return admittedPatients;
	}
	
	public String toString() {
		return this.name;
	}
	
	
	
	
}
