package hospital;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FinderTest {
	Department d = new InpatientDepartment("Department02",4);
	List<Department> dep = new ArrayList<Department>();
	JobRole job = hospital.JobRole.DOCTOR;
	Staff test = new Staff("Kilian", "Speiser", job,"email", 2, new Access(), d);
	
	@Test
	public void findDepartmentTest() {
		
		dep.add(d);
		Department m = Finder.findDepartment("Department02", dep);
		
		assertEquals(m.getName(),"Department02");
		
	}
	
	@Test
	public void addStaffTest() {
		
	}
	

}
