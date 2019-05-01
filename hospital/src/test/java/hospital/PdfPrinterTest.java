package hospital;

import org.junit.jupiter.api.Test;

public class PdfPrinterTest {
	
	Hospital hospital = System.loadData("src/test/data/departments.csv",  "src/test/data/staff.csv", "src/test/data/patients.csv");
	
	
	@Test
	public void test() {
		PDFgenerator.printDepartments(hospital);
	}
	

}
