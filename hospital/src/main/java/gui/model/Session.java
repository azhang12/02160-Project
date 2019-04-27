package gui.model;

public final class Session {

	
	//Role as String?
	private User user;
	private String role;
	
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
}