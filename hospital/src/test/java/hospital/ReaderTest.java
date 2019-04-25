package hospital;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;
import hospital.Reader;
public class ReaderTest {

	Reader r = new Reader();
	ArrayList <Department> d = r.readDepartment("src/test/data/departments.csv");
	ArrayList <Staff> s = r.readStaff(d, "src/test/data/staff.csv");
	
	@Test
	public void testReadDepartments() {
		
		for ( Department i :d)
		{
			System.out.println(i.getName());
		}
		assertEquals(5,d.size());
		
	}
	
	@Test
	public void testReadStaff() {
		
		for ( Staff i :s)
		{
			System.out.println(i.getEmail());
		}
		assertEquals(2,s.size());
		
	}
	
	
	

}
