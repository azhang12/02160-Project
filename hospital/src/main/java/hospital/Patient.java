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
	public Patient() {
	}
	
	// Constructor used to manually set fields -- useful for testing getters and setters (?)
	public Patient(String FirstName, String LastName, Department dep, String dob, String address, String phone, boolean living, int PatientNo, String national, Bed BedID, int queue) {
		super(FirstName,LastName,dep);
		this.birthday = dob;
		this.homeAddress = address;
		this.phoneNumber = phone;
		this.alive = living;
		this.patientNumber = PatientNo;
		this.bed = BedID;
		this.queueNumber = queue;
		this.nationality=national;
		if(BedID!=null) {
			registerObserver(BedID);
		}
		
		super.notifyObserver();
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
	public Boolean getAlive(){
		return this.alive;
	}
	public void setAlive(boolean newAlive){
		this.alive = newAlive;
	}
	public int getPatientNumber(){
		return this.patientNumber;
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
	public void setBed(Bed newBed,boolean update){
		if (this.getBed()!=null){
			this.getBed().setPatient(null);
		}
		
		this.bed = newBed;
		
		if(update) {
			updateObserverList();
			notifyObserver();
		}
	}
	
	
	public int getQueueNumber(){
		return this.queueNumber;
	}
	public void setQueueNumber(int newQueueNumber){
		this.queueNumber = newQueueNumber;
	}
	@Override
	public void updateObserverList() {
		super.updateObserverList();
		if(this.getBed()!=null) {
			this.registerObserver(this.getBed());
		}
		else {
			this.registerObserver(new Bed(this,0));
		}
		
	}
	@Override
	public void setDepartment(Department d) {
		if(d instanceof OutpatientDepartment) {
			((OutpatientDepartment)d).updateQueue();
		}
		super.setDepartment(d);
		this.setBed(null, true);
		this.setQueueNumber(0);
	}
}
