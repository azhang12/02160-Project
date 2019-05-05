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
	
   public static void printDepartments(Hospital hospital){
	   
// SET FONT STYLE
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
	       // List title(department names)
	       ArrayList<Department> departments = hospital.getDepartment();
	       
	       for(Department dept: departments) {
	    	   String deptName = dept.getName();
	    	   document.add(new Paragraph("\n"+deptName, titleFont));
	    	   
	    	   // List contents(patient information)
	    	   List orderedList = new List(List.ORDERED);
	    	   ArrayList<Patient> patients = dept.getPatients();
	    	   
	    	   for(Patient patient: patients) {
	    		   String pFirstName = patient.getFirstName();
	    		   String pLastName = patient.getLastName();
	    		   int pNum = patient.getPatientNumber();

	    		   boolean pStatus = patient.getAlive();
	    		   String alive ="";
	    		   if (pStatus) {alive = "Alive";}
	    		   else { alive = "Dead";}
	    		   
	    		   
	    		   orderedList.add(new ListItem(pNum+" | "+pFirstName+" "+pLastName+" | "+alive));
	    	   
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
