package gui.model;

public final class Session {

	
	//Role as String?
	private User user;
	private String role;
	private String department;
	
	public Session() {
		role = "Admin";
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getUserId() {
		return this.user.getUserId();
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String Role) {
		this.role=Role;
	}
	
	public String getDepartment() {
		return this.department;
		
	}
	
	public void setDepartment(String dep) {
		this.department=dep;
	}
}