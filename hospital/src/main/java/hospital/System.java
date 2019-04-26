package hospital;


public class System {
	
	
	
	public static void registerPatient(Hospital data, String FirstName, String LastName, Department dep, String dob, String address, String phone, boolean living, String national){
		
		
		Patient pat = new Patient(FirstName, LastName, dep, dob, address, phone, living, data.getPatient().size()+1, national, null,0);
		data.addPatient(pat);
		
	}

}
