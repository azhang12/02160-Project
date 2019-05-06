package hospital;

public abstract class Access {

	public Access() {
	};

	private boolean patient_data = false;

	private boolean patient_admission_data = false;

	private boolean staff_data = false;

	private boolean patient_registration = false;
	
	private boolean only_this_department_data = false;

	protected void enableAllAccess() {
		this.patient_data = true;
		this.patient_admission_data = true;
		this.staff_data = true;
		this.patient_registration = true;
		this.only_this_department_data = true;
	}

	// Patient Data
	protected void enablePatientDataAccess() {
		this.patient_data = true;
	}

	public boolean getPatientDataAccess() {
		return patient_data;
	}

	// Patient Admission
	protected void enablePatientAdmissionDataAccess() {
		this.patient_admission_data = true;
	}

	public boolean getPatientAdmissionDataAccess() {
		return patient_admission_data;
	}

	// Staff Data
	protected void enableStaffDataAccess() {
		this.staff_data = true;
	}

	public boolean getStaffDataAccess() {
		return staff_data;
	}

	// Patient Registration Data
	protected void enablePatientRegistationDataAccess() {
		this.patient_registration = true;
	}

	public boolean getPatientRegistationDataAccess() {
		return patient_registration;
	}
	
	// Patient Data
		protected void enableOtherDepartmentsAcces() {
			this.only_this_department_data= true;
		}

		public boolean getOtherDepartmetnsAccess() {
			return only_this_department_data;
		}
	
	@Override
	public abstract String toString();

}
