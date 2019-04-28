package hospital;

import java.util.ArrayList;
import java.util.List;

public class InpatientDepartment extends Department{

	private List<Bed> beds = new ArrayList<Bed>();
	
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
	
	
}
