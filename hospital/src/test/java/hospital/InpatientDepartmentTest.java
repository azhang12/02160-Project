package hospital;

import static org.junit.Assert.*;

import org.junit.Test;

public class InpatientDepartmentTest {
	
	InpatientDepartment testDepartment1 = new InpatientDepartment("1",1);
	InpatientDepartment testDepartment2 = new InpatientDepartment("2",1);
	Bed testBed = testDepartment1.getBed().get(0);
	
	Patient testPatient = new Patient("Bill", "Smith", testDepartment1, "22/04/1998", "Elektrovej, Kongens Lyngby 2800, Denmark", "+45927564", true, 1, "Danish", testBed, 1);
	
	@Test 
	public void checkAlreadyAssigned() {
		testPatient.setDepartment(testDepartment1);
		
		assertTrue(testPatient.getDepartment() == testDepartment1);
		
	}
	// admit patient if patient is not assigned to a department
	
	// admit patient if patient is already assigned to the current department
	
	// admit patient if patient is assigned to another department
	
	// admit patient if there is no room
	
	// admit patient if there is room (should be successful)
	
}