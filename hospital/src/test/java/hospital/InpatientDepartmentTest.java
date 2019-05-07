package hospital;

import static org.junit.Assert.*;

import org.junit.Test;

public class InpatientDepartmentTest {
	
	InpatientDepartment testDepartment = new InpatientDepartment("1",1);
	Bed testBed = testDepartment.getBed().get(0);
	
	Patient testPatient = new Patient("Bill", "Smith", testDepartment, "22/04/1998", "Elektrovej, Kongens Lyngby 2800, Denmark", "+45927564", true, 1, "Danish", testBed, 1);
	
	@Test 
	public void checkAlreadyAssigned() {
		testDepartment.admitPatient(testPatient);
		assertFalse(testDepartment.admitPatient(testPatient));
	}
	// admit patient if patient is not assigned to a department
	@Test 
	public void testPatientNotAssigned() {
		assertFalse(testDepartment.admitPatient(testPatient));
	}
	// admit patient if there is no room
	@Test 
	public void testNoMoreRoom() {
		InpatientDepartment testDepartment1 = new InpatientDepartment("1",0);
		Patient testPatient2 = new Patient("Bill", "Smith", testDepartment, "22/04/1998", "Elektrovej, Kongens Lyngby 2800, Denmark", "+45927564", true, 1, "Danish", testBed, 1);
		testDepartment1.admitPatient(testPatient2);
		
		assertFalse(testDepartment1.admitPatient(testPatient));
	}
}