package hospital;

public class Staff extends Person  {
	
	private JobRole jobRole;
	private String eMail;
	private int staffNumber;
	private Access access;
	
	//Constructor Implementation
	public Staff(String FirstName, String LastName, JobRole role, String mail,int staffNo,  Access level, Department dep) {
		
		super(FirstName,LastName,dep);
		this.jobRole= role;
		this.eMail = mail;
		this.staffNumber = staffNo;
		this.access = level;
		notifyObserver();
	}
	
	//Getters and Setters to get and set Data
	public JobRole getJobRole() {
		return this.jobRole;
	}
	public void setJobRole(JobRole newJobRole) {
		this.jobRole = newJobRole;
	}
	public String getEmail() {
		return this.eMail;
	}
	public void setEmail(String newEmail) {
		this.eMail=newEmail;
	}
	public int getStaffNumber() {
		return this.staffNumber;
	}
	public void setStaffNumber(int number) {
		this.staffNumber=number;
	}
	
	public void setAccessLevel(Access level) {
		this.access=level;
	}
	public Access getAccessLevel() {
		return this.access;
	}
	
	public Staff copy() {
		return new Staff(this.getFirstName(),this.getLastName(),this.getJobRole(),this.getEmail(),this.getStaffNumber(),this.getAccessLevel(),this.getDepartment());
		
	}
	

	

	


	

	
	
}
