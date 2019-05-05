package hospital;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ExporterTest {
	
	
	Exporter e = new Exporter();
	Hospital hospital = System.loadData("src/test/data/departments.csv",  "src/test/data/staff.csv", "src/test/data/patients.csv");
	@Test
	public void test() {
		
		Department dep1 = new InpatientDepartment("Department01",10);
		Department dep2 = new InpatientDepartment("Department02",11);
		Department dep3 = new OutpatientDepartment("Department03");
		
		List<Department> d= new ArrayList<Department>();
		d.add(dep1);
		d.add(dep2);
		d.add(dep3);
		assertTrue("File exists",e.export(d, "src/test/data/dep2.csv"));
		
	
		
	}
	
	@Test
	public void testPatients() {
		
		
		e.export(hospital.getPatient(), "src/test/data/pat2.csv");
		
		
	}
	
	@Test
	public void testStaff() {
		
		
		e.export(hospital.getStaff(), "src/test/data/staff2.csv");
		
		
	}

	@Test 
	public void testExceptionCatch() {
		assertFalse(e.export(hospital.getPatient(), "src/test/data/staff3.cs"));
	}
}
