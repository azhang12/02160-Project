package hospital;

public class ClericalAccess extends Access {
	
	ClericalAccess() {
		super();
		enablePatientAdmissionDataAccess();
		enablePatientRegistationDataAccess();
	}
	
	@Override
	public String toString() {
		return "Clerk";
	}
	
}
