// This class creates new PDF file named "ParticipationList.pdf" under the project folder.
// Refresh the whole project to find the file in package explorer.

package hospital;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.util.ArrayList;
import java.util.Iterator;

 
public class PDFgenerator{
	
   public static void printDepartments(Hospital hospital){
	   
// SET FONT STYLE
	   Font headFont = FontFactory.getFont(FontFactory.HELVETICA, 40, Font.BOLD, new CMYKColor(100,100,100,100));
	   Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, new CMYKColor(99, 18, 0, 95));

	   
	   
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
	       document.addSubject("A list of all patients admitted to a certain department at the moment");
	       
	       
	       
// MAKE LIST
	       // List title(department names)
	       
	       ArrayList<Department> departments = hospital.getDepartment();

	       Iterator<Department> deptNameIterator = departments.iterator();
	       while(deptNameIterator.hasNext()) {
	    	   ArrayList<Patient> patients = deptNameIterator.next().getPatients();
	    	   String deptName = deptNameIterator.next().getName();
	    	   document.add(new Paragraph("Department: "+deptName, titleFont));
	    	   
	    	   // List contents(patient information)
	    	   List orderedList = new List(List.ORDERED);
	    	   Iterator<Patient> patientIterator = patients.iterator();
	    	   while(patientIterator.hasNext()) {
	    		   int patientNumber = patientIterator.next().getPatientNumber();
	    		   String patientFirstName = patientIterator.next().getFirstName();
	    		   String patientLastName = patientIterator.next().getLastName();
	    		   boolean patientStatus = patientIterator.next().getAlive();
	    		   orderedList.add(new ListItem(patientNumber+" | "+patientFirstName+" "+patientLastName+" | "+patientStatus));
	    	   }
		       document.add(orderedList);
	       }

	       
	       
	       
// CLOSE DOCUMENT
	       document.close();
	       writer.close();
	       
	       
	   } catch (Exception e) {
	       e.printStackTrace();
	   }

	   
	   
      
   }
}
