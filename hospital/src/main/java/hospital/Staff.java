package hospital;

import java.util.ArrayList;
public class Staff extends Person implements ISubject {
	
	private JobRole jobRole;
	private String eMail;
	private int staffNumber;
	private Access access;
	private ArrayList<IObserver> observers;
	
	//Constructor Implementation
	public Staff(String FirstName, String LastName, JobRole role, String mail,int staffNo,  Access level, Department dep) {
		
		this.firstName = FirstName;
		this.lastName = LastName;
		this.jobRole= role;
		this.eMail = mail;
		this.staffNumber = staffNo;
		this.access = level;
		this.department = dep;
		observers = new ArrayList<IObserver>();
	}
	
	//Getters and Setters to get and set Data
	public JobRole getJobRole() {
		return this.jobRole;
	}
	public void setJobRole(JobRole newJobRole) {
		this.jobRole = newJobRole;
	}
	public String getEmail() {
		return this.eMail;
	}
	public void setEmail(String newEmail) {
		this.eMail=newEmail;
	}
	public int getStaffNumber() {
		return this.staffNumber;
	}
	public void setStaffNumber(int number) {
		this.staffNumber=number;
	}
	
	public void setAccessLevel(Access level) {
		this.access=level;
	}
	public Access getAccessLevel() {
		return this.access;
	}
	
	public Staff copy() {
		return new Staff(this.getFirstName(),this.getLastName(),this.getJobRole(),this.getEmail(),this.getStaffNumber(),this.getAccessLevel(),this.getDepartment());
		
	}

	@Override
	public void registerObserver(IObserver observer) {
		observers.add(observer);
		
	}

	@Override
	public void unregisterObserver(IObserver observer) {
		int observerIndex = observers.indexOf(observer);
		observers.remove(observerIndex);
		
	}

	@Override
	public void notifyObserver() {
		for ( IObserver observer: observers) {
			observer.update(this);
		}
		
	}

	
	
}
