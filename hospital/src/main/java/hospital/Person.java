// Eunjin Yoo

package hospital;
import java.util.*;

public class Person {
	
	private String firstName;
	private String lastName;
	private Department department;
	
	public Person(String _firstName, String _lastName, Department _department) {
		firstName = _firstName;
		lastName = _lastName;
		department = _department;
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String n) {
		firstName = n;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setlastName(String n) {
		lastName = n;
	}
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department d) {
		department = d;
	}
	
	

}
