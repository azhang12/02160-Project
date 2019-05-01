package hospital;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SystemReadDataTest {

	
	Hospital hospital = System.loadData("src/test/data/departments.csv",  "src/test/data/staff.csv", "src/test/data/patients.csv");
		
	
	@Test
	public void testReadDepartments() {
		
		
		assertEquals(5,hospital.getDepartment().size());
		
	}
	
	@Test
	public void testReadStaff() {
		
		
		assertEquals(2,hospital.getCntStaff());
		
	}
	
	@Test
	public void testReadPatients() {
	
		assertEquals(1,hospital.getCntPatients());
	}
	
}
