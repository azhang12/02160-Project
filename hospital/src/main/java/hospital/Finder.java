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
	
	public static int findPatientInt(List<Patient> patient, int patNo) {
		for (int i=0; i<patient.size();++i) {
			if(patient.get(i).getPatientNumber()==patNo) {
				return i;
			}
		}
		return -1;
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
	
	public static int findStaffInt(List<Staff> staff, int staffNo) {
		for (int i=0; i<staff.size();++i) {
			if(staff.get(i).getStaffNumber()==staffNo) {
				return i;
			}
		}
		return -1;
	}
	
	
	public static Staff findStaff(List<Staff> staff, int staffNo) {
		for (int i=0; i<staff.size();++i) {
			if(staff.get(i).getStaffNumber()==staffNo) {
				return staff.get(i);
			}
		}
		return null;
	}
	
	public static String findEmail(List<Staff> staff, String firstName, String lastName) {
		
		// removing spaces from first name and last name for email addresses. also converting all to lower case
		String fn = firstName.replace(" ", "").toLowerCase();
		String ln = lastName.replace(" ", "").toLowerCase();
		
		// looping through backwards should allow the system to find the email address with the highest number
		for (int i = staff.size()-1; i>=0; i--) {
			
			String em = staff.get(i).getEmail(); // get email address
			String emID = em.split("@")[0]; // isolate the part of the email before the "@"
			if (Pattern.matches(fn + "." + ln, emID)) { 
				return (fn + "." + ln + "2@hospital.dk"); // if only 1 exists
			}
			if (Pattern.matches(fn + "." + ln + "[0-9]*", emID)) { // if more than 1 exists
				int oldNum = Integer.parseInt(emID.replace(fn + "." + ln, ""));
				return (fn + "." + ln + (oldNum + 1) + "@hospital.dk");
			}
		}
		return (fn + "." + ln + "@hospital.dk"); // only returned if it is a unique email address

	}
	
	public static Access findAccess(JobRole role) {
		if(role==JobRole.CLERK) {
			return new ClericalAccess();
		}
		
		else if(role==JobRole.DOCTOR) {
			return new StaffAccess();
		}
		else if(role==JobRole.NURSE) {
			return new StaffAccess();
		}
		else  {
			return new ICTAccess();
		}
	}

	public static int findQueueNumber(OutpatientDepartment dep) {
		int output=0;
		for (Patient pat: dep.getPatients()) {
			if(pat.getQueueNumber()!=0) {
				if (pat.getQueueNumber()>output) {output=pat.getQueueNumber();}
			}
		}
		return output;
	}
		
}
