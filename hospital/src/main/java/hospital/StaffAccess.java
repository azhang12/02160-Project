package hospital;

public class StaffAccess extends Access {
	
	public StaffAccess() {
		super();
		enablePatientDataAccess();
		enablePatientAdmissionDataAccess();
	}
	
	@Override
	public String toString() {
		return "Staff";
	}

}
