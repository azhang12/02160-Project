package hospital

public class Bed extends DepartmentPatient {
	//variables
	private Patient patient;
	private int id;
	
	//constuctors
	public Bed() {}
	public Bed(Patient patient, int id){
		this.patient = patient;
		this.id = id;
	}
	
	//functions
	void setPatient(Patient newPatient) { 
		this.patient = newPatient; 
	}
	Patient getPatient() { 
		return this.patient; 
	}
	void setid(int id) { 
		this.id = id; 
	}
	int getid(int id) { 
		return this.id; 
	}
	boolean isOccupied() {
		if(this.patient != null) { 
			return true;
		}else return false;
	}

}
