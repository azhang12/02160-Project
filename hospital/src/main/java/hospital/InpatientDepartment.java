package hospital;

public class InpatientDepartment extends Department{

	private ArrayList<Bed> beds = new ArrayList<Bed>();
	
	public ArrayList<Bed> getBed() {
		return beds;
	}
	
	public void setBed(Patient patient) {
		int id = beds.size();
		Bed newBed = new Bed(patient, id);
		beds.add(newBed);
	}
	
	public void moveBed(Bed oldBed, Bed newBed) {
		Patient patient = oldBed.patient;
		newBed.setPatient = patient;
		oldBed.patient = null;
	}
	
}
