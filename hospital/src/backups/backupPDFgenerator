/* This class creates new PDF file named "ParticipationList.pdf"
under the very top-level folder(the 'hospital' project folder in this case).
Refresh the whole project to see the file in package explorer.*/

package hospital;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.util.ArrayList;
 
public class PDFgenerator{
	
	private static ArrayList<String> patientListing(ArrayList<Patient> patients) {
		
		ArrayList<String> returnList = new ArrayList();
		for(Patient p : patients) {
 		   String name = p.getFirstName() + " " +p.getLastName();
 		   int pNum = p.getPatientNumber();
 		   String status;
 		   
 		   if(p.getAlive()) {
 			   status = "alive";
 		   } else {
 			   status = "dead";
 		   }
 		   
 		   String item =name + "    |    No." + pNum + "    |    " + status;
 		   
 		   returnList.add(item);
 	   }
		return returnList;
	}
	
	public static void printDepartments(Hospital hospital){
		
//	 	SET FONT STYLE
			Font headFont = FontFactory.getFont(FontFactory.HELVETICA, 30, Font.BOLD, new CMYKColor(100,100,100,100));
			Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD, new CMYKColor(99, 18, 0, 95));

		   
		   
	// OPEN NEW DOCUMENT	   
			Document document = new Document();
			try{
				
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/test/data/ParticipationList.pdf"));
				document.open();
				document.add(new Paragraph("PARTICIPATION LIST\n", headFont));
		    
		       
	// SET FILE ATTRIBUTES
				document.addAuthor("kaget");
				document.addCreationDate();
				document.addCreator("kaget");
				document.addTitle("ParticipationList");
				document.addSubject("A list of all departments, patients and there current status");
		       
		       
		       
	// MAKE LIST
		       
				ArrayList<Department> departments = hospital.getDepartment();
				for (Department d : departments) {
					document.add(new Paragraph("\n" + d.getName(), titleFont));
			    	   
					ArrayList<Patient> patients = d.getPatients();
					
					ArrayList<String> patientsList = patientListing(patients);
					
					int i = 1;
					for(String item : patientsList) {
						if(i%2 == 1) {
							document.add(new Paragraph("#    " + item));
						}
						i++;
					}
					
				}
		       
		       
		       
		       
	// CLOSE DOCUMENT
				document.close();
				writer.close();
				
		       
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
}
