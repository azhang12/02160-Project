package hospital;
import java.util.ArrayList;
import java.util.List;

public class Department {
	
	private String name;
	
	public String getName() {return this.name;}
	
	private ArrayList<Staff> staff = new ArrayList<Staff>();
	
	private ArrayList<Patient> admittedPatients = new ArrayList<Patient>();
	
	// Constructor
	Department(String Name){this.name = Name;}
	
	public boolean admitPatient(Patient newPatient) {
		return this.admittedPatients.add(newPatient);
	}
	
	public boolean dischargePatient(Patient patient) {
		return this.admittedPatients.remove(patient);
	}
	
	public boolean addStaff(Staff newStaff) {
		return this.staff.add(newStaff);
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
	
	
	
	
}
