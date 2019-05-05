package hospital;

import static org.junit.Assert.*;

import org.junit.Test;

public class DepartmentTest {
	Department dep = new InpatientDepartment("hi",12);
	
	Patient pat = new Patient("Kilian","Speiser",null,"Dezember","Germany","342323",true,123421,"Germany",new Bed(),0);
	
	
	
	@Test
	public void admitPatientTest() {
		int n = dep.getPatients().size();
		assertEquals(dep.getPatients().size(),0);
		dep.admitPatient(pat);
		assertEquals(dep.getPatients().size(),1);
	}
}