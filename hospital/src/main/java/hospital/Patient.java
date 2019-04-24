package hospital;

public class Patient extends Person {

	private String birthday;
	private String homeAddress;
	private String phoneNumber;
	private boolean alive;
	private int patientNumber;
	private String nationality;
	private Bed bed;
	private int queueNumber;

	// Constructors
	public Patient(String FirstName, String LastName, Department dep, String dob, String address, String phone, boolean living, int PatientNo, String national, Bed BedID, int queue) {
		this.firstName = FirstName;
		this.lastName = LastName;
		this.department = dep;
		this.birthday = dob;
		this.homeAddress = address;
		this.phoneNumber = phone;
		this.alive = living;
		this.patientNumber = PatientNo;
		this.nationality = national;
		this.bed = BedID;
		this.queueNumber = queue;
	}

	// Getters and setters
	public String getBirthday() {
		return this.birthday;
	}
	public void setBirthday() {
		this.birthday = newBirthday;
	}
	public String getAddress(){
		return this.homeAddress;
	}
	public void setAddress() {
		this.homeAddress = newAddress;
	}
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public void setPhoneNumber(){
		this.phoneNumber = newPhoneNumber;
	}
	public Boolean IsAlive(){
		return this.alive;
	}
	public void setAlive(){
		this.alive = newAlive;
	}
	public int getPatientNumber(){
		return this.patientNumber;
	}
	public void setPatientNumber(){
		this.patientNumber = newPatientNumber;
	}
	public String getNationality(){
		return this.nationality;
	}
	public void setNationality(){
		this.nationality = newNationality;
	}
	public Bed getBed(){
		return this.bed;
	}
	public void setBed(){
		this.bed = newBed;
	}
	public int getQueueNumber(){
		return this.queueNumber;
	}
	public void setQueueNumber(){
		this.queueNumber = newQueueNumber;
	}
}
