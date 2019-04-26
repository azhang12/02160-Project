package hospital;

import java.util.List;

public class System {
	
	
	
	public static void registerPatient(Hospital data, String FirstName, String LastName, String depName, String dob, String address, String phone, boolean living, String national){
		
		Department  dep = Finder.findDepartment(depName, data.getDepartment());
		Patient highest = (Patient) data.getPatient().get(data.getPatient().size()-1).;
		int num = highest.getPatientNumber();
		
		Patient pat = new Patient(FirstName, LastName, dep, dob, address, phone, living, num, national, null,0);
		data.addPatient(pat);
		
	}
	
	public static void admitPatient(Hospital data, int PatientNumber , String DepartmentName) {
		
		Patient pat = Finder.findPatient(PatientNumber, data.getPatient());
		Department dep = Finder.findDepartment(DepartmentName, data.getDepartment());
		
		pat.setDepartment(dep);
				
	}

}
