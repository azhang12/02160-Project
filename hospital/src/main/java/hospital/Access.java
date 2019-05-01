package hospital;

public abstract class Access {

	public Access() {
	};

	private boolean patient_data = false;

	private boolean patient_admission_data = false;

	private boolean staff_data = false;

	private boolean patient_registration = false;

	protected void enableAllAccess() {
		this.patient_data = true;
		this.patient_admission_data = true;
		this.staff_data = true;
		this.patient_registration = true;
	}

	// Patient Data
	protected void enablePatientDataAccess() {
		this.patient_data = true;
	}

	protected boolean getPatientDataAccess() {
		return patient_data;
	}

	// Patient Admission
	protected void enablePatientAdmissionDataAccess() {
		this.patient_admission_data = true;
	}

	protected boolean getPatientAdmissionDataAccess() {
		return patient_admission_data;
	}

	// Staff Data
	protected void enableStaffDataAccess() {
		this.staff_data = true;
	}

	protected boolean getStaffDataAccess() {
		return staff_data;
	}

	// Patient Registration Data
	protected void enablePatientRegistationDataAccess() {
		this.patient_registration = true;
	}

	protected boolean getPatientRegistationDataAccess() {
		return patient_registration;
	}
	
	@Override
	public abstract String toString();

}
