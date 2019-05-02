package hospital;

public class ClericalAccess extends Access {
	
	ClericalAccess() {
		super();
		enableAllAccess();
	}
	
	@Override
	public String toString() {
		return "Clerk";
	}
	
}
