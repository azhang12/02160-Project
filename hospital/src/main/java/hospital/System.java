package hospital;

import java.util.ArrayList;

public class System {
	
	
	
	public static boolean registerPatient(Hospital data, String FirstName, String LastName, String dob, String address, String phone, boolean living, String national){
		
		
		Patient highest = (Patient) data.getPatient().get(data.getPatient().size()-1);
		int num = highest.getPatientNumber()+1;
		
		Patient pat = new Patient(FirstName, LastName, null, dob, address, phone, living, num, national, null,0);
		data.addPatient(pat);
		return true;
	}
	
	
	
	public static void admitPatient(Hospital data, int PatientNumber , String DepartmentName) {
		
		Patient pat = Finder.findPatient(PatientNumber, data.getPatient());
		Department dep = Finder.findDepartment(DepartmentName, data.getDepartment());
		pat.setDepartment(dep);	
	}
	
	public static void dischargePatient(Hospital data, int PatientNumber) {
		Patient pat = Finder.findPatient(PatientNumber, data.getPatient());
		pat.setDepartment(null);
	}
	
	
	
	public static boolean registerStaff(Hospital data,String FirstName, String LastName, String jobRole, String depName ) {
		Department  dep = Finder.findDepartment(depName, data.getDepartment());
		Staff highest = (Staff) data.getStaff().get(data.getStaff().size()-1);
		int num = highest.getStaffNumber()+1;

		String mail = Finder.findEmail(data.getStaff(), FirstName, LastName);
		JobRole role = Finder.findJobRole(jobRole);
		Access access = Finder.findAccess(role);
		
		if(dep!=null&&role!=null) {
			Staff s = new Staff(FirstName, LastName, role, mail,num,  access, dep);
			data.addStaff(s);
			return true;
		}
		else return false;
		
	}
	
	
	
	public static Hospital loadData(String DepartmentFileName, String StaffFileName, String PatientsFileName) {
		Reader r = new Reader();
		ArrayList<Department> departments = r.readDepartment(DepartmentFileName);
		ArrayList<Staff> staff = r.readStaff(departments, StaffFileName);
		ArrayList<Patient> patients = r.readPatients(departments, PatientsFileName);
		return new Hospital (departments, staff,patients);
		
	}
	
	public static void exportData(Hospital hosp) {
		Exporter e = new Exporter();
		e.export(hosp.getDepartment(), "src/test/data/depExport.csv");
		e.export(hosp.getStaff(), "src/test/data/staffExport.csv");
		e.export(hosp.getPatient(), "src/test/data/patExport.csv");
		
	}
	
	public static void addDepartment(Hospital hosp, String DepartmentName, int bedNo) {
		if(bedNo==0) {
			OutpatientDepartment department = new OutpatientDepartment(DepartmentName);
			hosp.getDepartment().add(department);
		}
		else {
			InpatientDepartment department = new InpatientDepartment(DepartmentName,bedNo);
			hosp.getDepartment().add(department);
		}
	}
	
	



	public static boolean editStaff(Hospital hosp,Staff staff, String newFirstName, String newLastName, String newDepartment, String newJobRole) {
	
		Department currentDep = Finder.findDepartment(staff.getDepartment().getName(),hosp.getDepartment());
		Department newDep = Finder.findDepartment(newDepartment,hosp.getDepartment());
		JobRole newRole = Finder.findJobRole(newJobRole);
		
		if(newRole!=null && newDep!=null) {
			//Change the Staff
			staff.setFirstName(newFirstName);
			staff.setLastName(newLastName);
			staff.setDepartment(newDep);
			staff.setJobRole(newRole);
			
			//Update the Department
			currentDep.removeStaff(staff);
			newDep.addStaff(staff);
			return true;
		}
		else return false;
		
		
	}
	
	
	public static boolean editPatient(Hospital hospital, Patient patient, String newFirstName, String newLastName, String newBirthday,
			String newAddress, String newPhoneNumber, String newNationality) {
		
		if(newFirstName!=null) {
			patient.setFirstName(newFirstName);
		}
		
		if(newLastName!=null) {
			patient.setLastName(newLastName);
		}
		
		if(newBirthday!=null) {
			patient.setBirthday(newBirthday);
		}
		
		if(newAddress!=null) {
			patient.setAddress(newAddress);
		}
		
		if(newPhoneNumber!=null) {
			patient.setPhoneNumber(newPhoneNumber);
		}
		
		if(newNationality!=null) {
			patient.setNationality(newNationality);
		}
		
		return false;
	}
	
	
	
	public static boolean printPDF(Hospital hospital) {
		PDFgenerator.printDepartments(hospital);
		return true;
		
	}
	public static boolean callPatient(Hospital hospital, Patient pat, int newId) {
		if (pat.getDepartment() instanceof InpatientDepartment){
			if(pat.getBed()==null) {
				InpatientDepartment dep = (InpatientDepartment)pat.getDepartment();
				Bed b = Finder.findBed(newId, dep.getBed());
				if(b.isOccupied()) {return false;}
				pat.setBed(b, true);
				return true;
			}
			else {
				return false;
			}
			
		}
		else if(pat.getDepartment() instanceof OutpatientDepartment) {
			if(pat.getQueueNumber()==1) {
				
				OutpatientDepartment dep = (OutpatientDepartment)pat.getDepartment();
				
				dep.removeFromQueue(pat);
				pat.setQueueNumber(0);
				dep.admittedPatients.remove(dep.admittedPatients.indexOf(pat));
				pat.setDepartment(null);
				dep.updateQueue();
				return true;
			}
			else {
				return false;
			}
		}
		
		return false;
		
	}



	public static void removeStaff(Hospital hospital, int staffNo) {
		Staff s = Finder.findStaff(hospital.getStaff(), staffNo);
		int i = hospital.getStaff().indexOf(s);
		int i2 = s.getDepartment().getStaff().indexOf(s);
		hospital.getStaff().remove(i);
		s.getDepartment().getStaff().remove(i2);
		
	}



	public static void removePatient(Hospital hospital, int patNo) {
		Patient s = Finder.findPatient(patNo, hospital.getPatient());
		int i = hospital.getPatient().indexOf(s);
		int i2 = s.getDepartment().getPatients().indexOf(s);
		hospital.getPatient().remove(i);
		s.getDepartment().getPatients().remove(i2);
	}




	
	
	
	
	
	
	

}
