package hospital;

import java.util.List;

public class System {
	
	
	
	public static void registerPatient(Hospital data, String FirstName, String LastName, String depName, String dob, String address, String phone, boolean living, String national){
		
		Department  dep = Finder.findDepartment(depName, data.getDepartment());
		Patient highest = (Patient) data.getPatient().get(data.getPatient().size()-1).;
		int num = highest.getPatientNumber()+1;
		
		Patient pat = new Patient(FirstName, LastName, dep, dob, address, phone, living, num, national, null,0);
		data.addPatient(pat);
		
	}
	
	public static void admitPatient(Hospital data, int PatientNumber , String DepartmentName) {
		
		Patient pat = Finder.findPatient(PatientNumber, data.getPatient());
		Department dep = Finder.findDepartment(DepartmentName, data.getDepartment());
		
		pat.setDepartment(dep);
		dep.admitPatient(pat);
		
				
	}
	
	public static void dischargePatient(Hospital data, int PatientNumber) {
		Patient pat = Finder.findPatient(PatientNumber, data.getPatient());
		Department dep = Finder.findDepartment(pat.getDepartment().getName(), data.getDepartment());
		pat.setDepartment(null);
		dep.dischargePatient(pat);
	}
	
	public static void movePatient(Hospital data, int PatientNumber, String newDepartment) {
		
		dischargePatient(data, PatientNumber);
		admitPatient(data,PatientNumber,newDepartment);
		
	}
	
	public static boolean movePatient(Hospital data, int PatientNumber, int newBed) {
		Patient pat = Finder.findPatient(PatientNumber, data.getPatient());
		
		if(pat.getDepartment().getClass()==new InpatientDepartment().getClass()) {
			InpatientDepartment ndep = (InpatientDepartment) pat.getDepartment();
			pat.setBed(Finder.findBed(newBed, ndep.getBed()));
			return true;
		}
		else return false;
	}
	/*
	IMPLEMENT THE FUNCTION COMPLETELY
	public static boolean registerStaff(Hospital data,String FirstName, String LastName, String jobRole, String depName ) {
		Department  dep = Finder.findDepartment(depName, data.getDepartment());
		Staff highest = (Staff) data.getStaff().get(data.getStaff().size()-1).;
		int num = highest.getStaffNumber()+1;
		String mail = FirstName+"."+LastName+"@hospital.dk";
		
		Staff s = new Staff(FirstName, LastName, JobRole role, String mail,num,  new Access(), dep);
		data.addStaff(s);
	}
	
	*/
	
	

}
