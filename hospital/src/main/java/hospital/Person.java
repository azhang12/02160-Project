// Eunjin Yoo

package hospital;
import java.util.*;

public class Person {
	
	private String firstName;
	private String lastName;
	private Department department;
	private String nationality;
	
	public Person(String _firstName, String _lastName, Department _department, String _nationality) {
		firstName = _firstName;
		lastName = _lastName;
		department = _department;
		nationality = _nationality;
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
	
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String n) {
		nationality = n;
	}
	

}
