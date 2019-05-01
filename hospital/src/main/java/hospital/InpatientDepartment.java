package hospital;

import java.util.ArrayList;
import java.util.List;

public class InpatientDepartment extends Department{

	private List<Bed> beds = new ArrayList<Bed>();
	
	public InpatientDepartment() {}
	public InpatientDepartment(String name, int noOfBeds) {
		super(name);
		this.beds = new ArrayList<Bed>();
		for(int i=0; i<noOfBeds;++i) {
			this.addBed();
		}
	}
	
	public List<Bed> getBed() {
		return beds;
	}
	public void addBed() {
		this.beds.add(new Bed(null,this.beds.size()+1));
	}
	
	public void setBeds(List<Bed> newBeds) {
		this.beds= newBeds;
	}
	
	public void moveBed(Bed oldBed, Bed newBed) {
		Patient patient = oldBed.getPatient();
		newBed.setPatient(patient);
		oldBed.setPatient(null);
	}
	
	public int occupiedBeds() {
		int n=0;
		for (Bed b : beds) {
			if(b.isOccupied()) {n++;}
			
		}
		return n;
	}
	
	@Override
	public boolean admitPatient(Patient newPatient) {
		if (newPatient.getDepartment() == null) { // checking to see if patient is already admitted
			if (admittedPatients.size() < getBed().size()) { // checking that there are available beds in the dept // this should be changed to allow for patients that are not admitted 
				return this.admittedPatients.add(newPatient);
			} else {
				return false; // no room in department
			}
		} else {
			return false; // already admitted to department;
		}
		
	}
	
}
