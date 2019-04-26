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
	// constructor if the clerk wants to have a patient number automatically assigned
	// need to remove the patient number in the final implementation of this. this is just kept here for now for the other test cases
	public Patient(String FirstName, String LastName, Department dep, String dob, String address, String phone, boolean living, int PatientNo, String national, Bed BedID, int queue) {
		this.firstName = FirstName;
		this.lastName = LastName;
		this.department = dep;
		this.birthday = dob;
		this.homeAddress = address;
		this.phoneNumber = phone;
		this.alive = living;
		this.patientNumber = PatientNo;
		// the above should be swapped to a scenario where we need to add to the previous highest patient number
		this.nationality = national;
		this.bed = BedID;
		this.queueNumber = queue;
	}

	// Getters and setters
	public String getBirthday() {
		return this.birthday;
	}
	public void setBirthday(String newBirthday) {
		this.birthday = newBirthday;
	}
	public String getAddress(){
		return this.homeAddress;
	}
	public void setAddress(String newAddress) {
		this.homeAddress = newAddress;
	}
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	public void setPhoneNumber(String newPhoneNumber){
		this.phoneNumber = newPhoneNumber;
	}
	public Boolean IsAlive(){
		return this.alive;
	}
	public void setAlive(boolean newAlive){
		this.alive = newAlive;
	}
	public int getPatientNumber(){
		return this.patientNumber;
	}
	public void setPatientNumber(int newPatientNumber){
		this.patientNumber = newPatientNumber;
	}
	public String getNationality(){
		return this.nationality;
	}
	public void setNationality(String newNationality){
		this.nationality = newNationality;
	}
	public Bed getBed(){
		return this.bed;
	}
	public void setBed(Bed newBed){
		this.bed = newBed;
	}
	public int getQueueNumber(){
		return this.queueNumber;
	}
	public void setQueueNumber(int newQueueNumber){
		this.queueNumber = newQueueNumber;
	}
}
