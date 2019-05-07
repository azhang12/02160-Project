package hospital;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class BedTesting {
	
	Bed b = new Bed(null,2);
	
	
	
	@Test
	public void setIdTest() {
		assertEquals(b.getId(),2);
		b.setId(5);
		assertEquals(b.getId(),5);
	}
	
	
	
	
	

}
