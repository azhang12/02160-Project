package hospital

<<<<<<< HEAD
public class Bed extends Department {
=======

public class Bed  {
>>>>>>> ed79782da117aa89f5b88cd3fc9135cbf630442f
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
	public void setPatient(Patient newPatient) { 
		this.patient = newPatient; 
	}
	public Patient getPatient() { 
		return this.patient; 
	}
	private void setId(int id) { 
		this.id = id; 
	}
	public int getId() { 
		return this.id; 
	}
	public boolean isOccupied() {
		if(this.patient != null) { 
			return true;
		}else return false;
	}

}
