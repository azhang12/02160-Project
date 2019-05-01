package hospital;

public class StaffAccess extends Access {
	
	StaffAccess() {
		super();
		enablePatientDataAccess();
		enablePatientAdmissionDataAccess();
	}
	
	@Override
	public String toString() {
		return "Staff";
	}

}
