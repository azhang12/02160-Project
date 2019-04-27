package hospital;

import java.util.ArrayList;
import java.util.List;

public class InpatientDepartment extends Department{

	private List<Bed> beds = new ArrayList<Bed>();
	public List<Bed> getBed() {
		return beds;
	}
	
	public void setBeds(List<Bed> newBeds) {
		this.beds= newBeds;
	}
	
	public void moveBed(Bed oldBed, Bed newBed) {
		Patient patient = oldBed.getPatient();
		newBed.setPatient(patient);
		oldBed.setPatient(null);
	}
	
	
	
}
