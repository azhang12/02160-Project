package gui.model;

import hospital.Access;
import hospital.Staff;

public final class Session {

	
	//Role as String?
	private Staff user;
	
	public Session() {
		
	}

	public void setUser(Staff user) {
		this.user = user;
	}
	
	public int getUserId() {
		return this.user.getStaffNumber();
	}
	
	public Staff getUser() {
		return user;
	}
	
	public String getDepartment() {
		return this.user.getDepartment().getName();
		
	}
	
	public Access getAccess() {
		return this.user.getAccessLevel();
	}
}