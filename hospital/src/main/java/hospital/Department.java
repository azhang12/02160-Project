package hospital;

import java.util.ArrayList;
import java.util.List;

public abstract class Department implements IObserver {

	protected String name;

	public String getName() {
		return this.name;
	}

	protected ArrayList<Staff> staff = new ArrayList<Staff>();

	protected ArrayList<Patient> admittedPatients = new ArrayList<Patient>();

	// Constructor
	Department() {
	}

	Department(String Name) {
		this.name = Name;
		this.admittedPatients= new ArrayList<Patient>();
		this.staff = new ArrayList<Staff>();
	}

	// 
	public boolean admitPatient(Patient newPatient) {
		return this.admittedPatients.add(newPatient);	
	}

	public boolean dischargePatient(Patient patient) {
		return this.admittedPatients.remove(patient);
	}

	public void addStaff(Staff newStaff) {
		this.staff.add(newStaff);
	}

	public boolean removeStaff(Staff staff) {
		return this.staff.remove(staff);
	}

	public ArrayList<Staff> getStaff() {
		return staff;
	}

	public ArrayList<Patient> getPatients() {
		return admittedPatients;
	}

	public String toString() {
		return this.name;
	}
	
	public void setPatient(ArrayList<Patient> newList) {
		this.admittedPatients=newList;
	}
	public void setStaff(ArrayList<Staff> newList) {
		this.staff=newList;
	}
	@Override
	public void update(Person toUpdate) {
		if(toUpdate instanceof Staff) {
			//Remove Staff from old Department
			int i=this.staff.indexOf(toUpdate);
			if(i!=-1) {
				this.staff.remove(i);
				//Remove old Observer from oberverArray
			}
			toUpdate.getDepartment().addStaff((Staff)toUpdate);
		}
	
		else if(toUpdate instanceof Patient) {
			//Remove Patient from old Department
			int i=this.admittedPatients.indexOf(toUpdate);
			if(this instanceof OutpatientDepartment) {
				updateQueue();
			}
			
			if(i!=-1) {
				this.admittedPatients.remove(i);
				//Remove old Observer from oberverArray
			}
			
			if(toUpdate.getDepartment()!=null) {
				List<Patient> newDep = toUpdate.getDepartment().getPatients();
				newDep.add((Patient) toUpdate);
				
			}
		}
			
			
	}
		public void updateQueue(){{
			if(this instanceof OutpatientDepartment) {
				((OutpatientDepartment)this).getQueue().clear();
				for (int i=0; i<this.admittedPatients.size();++i) {
					((OutpatientDepartment)this).getQueue().add(admittedPatients.get(i));
					admittedPatients.get(i).setQueueNumber(i+1);
				}
			}
			
		}
	}
}
	

	

	




