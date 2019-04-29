package hospital;

import java.util.Arrays;
import java.util.List;

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
}
