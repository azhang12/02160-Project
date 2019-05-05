package hospital;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import hospital.Reader;
public class ReaderTest {

	Reader r = new Reader();
	ArrayList <Department> d = r.readDepartment("src/test/data/depExport.csv");
	ArrayList <Staff> s = r.readStaff(d, "src/test/data/staffExport.csv");
	ArrayList <Patient> p = r.readPatients (d, "src/test/data/patExport.csv");
	
	
	
	@Test
	public void testReadDepartments() {
		
		
		assertEquals(5,d.size());
		
	}
	
	@Test
	public void testReadStaff() {
		
		
		assertEquals(4,s.size());
		
	}
	
	
	@Test
	public void testReadPatients() {
	
		assertEquals(2,p.size());
	}
	
	@Test 
	public void testStaffinDepartment(){
		assertTrue("Staff works for the Department",0==d.get(2).getStaff().size());
	}
	
	@Test 
	public void testPatientsinDepartment(){
		assertTrue("Patient is admitted to the Department01",2==d.get(0).getPatients().size());
	}
	
	public void testPatintQueue() {
		
		Patient pat = new Patient("Jamal","Peters",d.get(3),"November","Cologne","+223132",false,2,"Germany",new Bed(),1);
		
		
		assertTrue("Patient is added to Queue", d.get(3).getPatients().get(0).getQueueNumber()==1);
	}
	
	@Test 
	public void testException() {
		String exc = "depart.cs";
		assertEquals(r.read(exc),null);
		
	}
	
	
	

}
