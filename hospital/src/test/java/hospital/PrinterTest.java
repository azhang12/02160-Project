package hospital;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PrinterTest {
	
	
	Exporter e = new Exporter();
	@Test
	public void test() {
		
		Department dep1 = new Department("Department01");
		Department dep2 = new Department("Department02");
		Department dep3 = new Department("Department03");
		
		List<Department> d= new ArrayList<Department>();
		d.add(dep1);
		d.add(dep2);
		d.add(dep3);
		assertTrue("File exists",e.export(d, "src/test/data/dep2.csv"));
		
	
		
	}
	
	@Test
	public void fileFalse() {
		Department dep1 = new Department("Department01");
		Department dep2 = new Department("Department02");
		Department dep3 = new Department("Department03");
		
		List<Department> d= new ArrayList<Department>();
		d.add(dep1);
		d.add(dep2);
		d.add(dep3);
		assertFalse("File exists",e.export(d, "src/test/data/dep2.cs"));
	}

}
