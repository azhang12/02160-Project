package hospital;



public class Bed implements IObserver{

	//variables
	private Patient patient;
	private int id;
	
	//Constructors
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
	public void setId(int id) { 
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
	@Override
	public void update(Person toUpdate) {
		Bed newBed = ((Patient)toUpdate).getBed();
		Bed oldBed = this;
		
		//Empty oldBed
		oldBed.setPatient(null);
		//Remove Patient from new Bed
		if(newBed!=null) {
			if(newBed.getPatient()!=null) {
				newBed.getPatient().setBed(null, true);
				newBed.setPatient(null);
			}
			//Set Patient to new Bed
			this.setPatient((Patient)toUpdate);
			this.getPatient().setBed(this, false);
			
			//Update Bed in Department
			if(toUpdate.getDepartment() instanceof InpatientDepartment) {
				InpatientDepartment dep = (InpatientDepartment)toUpdate.getDepartment();
				int i = dep.getBed().indexOf(this);
				dep.getBed().get(i).setPatient((Patient)toUpdate);
			}
				
			
		}
		
			
	}
	
		
		
		
}
	
	


