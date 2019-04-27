import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
package hospital;

public class Hospital{
	//array lists
	private List<Staff> staffList = new ArrayList<Staff>();
	private List<Patient> patientList = new ArrayList<Patient>();
	private List<Department> departmentList = new ArrayList<Department>();
	
	//constructor
	Hospital() {}
	
	//modifying lists of Staff, Patients, and Departments
	public void addStaff(Staff newStaff) {
		this.staffList.add(newStaff);
	}
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
		patient.setBed(newBed);
	}
		
	public void addDepartment(Department newDepartment) {
		this.departmentList.add(newDepartment);
	}
	public void removeDepartment(Department rmDepartment) {
		this.departmentList.remove(rmDepartment);
	}
	//getters
	public List getStaff() {
		return staffList;
	}
	public List getPatient() {
		return patientList;
	}
	public List getDepartment() {
		return departmentList;
	}
		
}
