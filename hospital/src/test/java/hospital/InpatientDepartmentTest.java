package hospital;

import static org.junit.Assert.*;

import org.junit.Test;

public class InpatientDepartmentTest {
	
	InpatientDepartment testDepartment1 = new InpatientDepartment();
	InpatientDepartment testDepartment2 = new InpatientDepartment();
	
	Patient testPatient = new Patient("Bill", "Smith", null, "22/04/1998", "Elektrovej, Kongens Lyngby 2800, Denmark", "+45927564", true, 1, "Danish", null, null);
	
	@Test 
	public void checkAlreadyAssigned() {
		testPatient.setDepartment(testDepartment1);
		
		assertTrue(test.getDepartment() == testDepartment1);
		
	}
	// admit patient if patient is not assigned to a department
	
	// admit patient if patient is already assigned to the current department
	
	// admit patient if patient is assigned to another department
	
	// admit patient if there is no room
	
	// admit patient if there is room (should be successful)
	
}