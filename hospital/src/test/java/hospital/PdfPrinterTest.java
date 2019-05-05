package hospital;

import org.junit.jupiter.api.Test;

public class PdfPrinterTest {
	
	Hospital hospital = System.loadData("src/test/data/depExport.csv",  "src/test/data/staffExport.csv", "src/test/data/patExport.csv");
	
	
	@Test
	public void test() {
		PDFgenerator.printDepartments(hospital);
	}
	

}
