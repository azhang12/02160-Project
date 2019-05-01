package hospital;

public class ClericalAccess extends Access {
	
	ClericalAccess() {
		super();
		enablePatientAdmissionDataAccess();
		enablePatientRegistationDataAccess();
	}
	
}
