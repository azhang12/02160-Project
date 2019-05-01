package hospital;

import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class Finder {

	public static JobRole findJobRole(String abbr){
	    return Arrays.stream(JobRole.values()).filter(value -> value.toString().equalsIgnoreCase(abbr)).findFirst().orElse(null);
	}
	
	public static Department findDepartment(String depName, List<Department> departmentList) {
		for (Department department : departmentList) {
			if(depName.equals(department.getName())) {
				return department;
			}
			
		}
		return null;
	}
	
	public static Patient findPatient(int PatientNumber, List<Patient> patientList) {
		for (Patient pat : patientList) {
			if(pat.getPatientNumber()==PatientNumber)
			{
				return pat;
				
			}
			
		}
		return null;
	}
	
	public static Bed findBed(int bedNumber, List<Bed> bedList) {
		for (Bed bed : bedList) {
			if(bed.getId()==bedNumber)
			{
				return bed;
			}
			
		}
		return null;
	}
	
	public static int findStaff(List<Staff> staff, int staffNo) {
		for (int i=0; i<staff.size();++i) {
			if(staff.get(i).getStaffNumber()==staffNo) {
				return i;
			}
		}
		return -1;
	}
	
	public static String findEmail(List<Staff> staff, String firstName, String lastName) {
		
		// removing spaces from first name and last name for email addresses. also converting all to lower case
		String fn = firstName.replace(" ", "").toLowerCase();
		String ln = lastName.replace(" ", "").toLowerCase();
		
		// looping through backwards should allow the system to find the email address with the highest number
		for (int i = staff.size()-1; i>=0; i--) {
			
			String em = staff.get(i).getEmail(); // get the staff member's email address
			String emID = em.split("@")[0]; // isolate the part of the email before the "@"
			if (Pattern.matches(fn + "." + ln, emID)) { 
				return (fn + "." + ln + "2@hospital.dk"); // if only 1 exists
			}
			if (Pattern.matches(fn + "." + ln + "[0-9]*", emID)) { // if more than 1 exists
				int oldNum = Integer.parseInt(emID.replace(fn + "." + ln, ""));
				return (fn + "." + ln + (oldNum + 1) + "@hospital.dk");
			}
		}
		return (fn + "." + ln + "@hospital.dk"); // this is only returned if it was already an original email address

	}
		
}
