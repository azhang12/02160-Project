package hospital;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.util.ArrayList;

 
public class PDFgenerator{
	
   public static void main(String[] args){
	   
// SET FONT STYLE
	   Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, new CMYKColor(99, 18, 0, 95));

	   
	   
// OPEN NEW DOCUMENT	   
	   Document document = new Document();
	   try{
	       PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("ParticipationList.pdf"));
	       document.open();
	    
	       
// SET FILE ATTRIBUTES
	       document.addAuthor("kaget");
	       document.addCreationDate();
	       document.addCreator("kaget");
	       document.addTitle("ParticipationList");
	       document.addSubject("A list of all patients admitted to a certain department at the moment");
	       
	       
	       
// MAKE LIST
	       document.add(new Paragraph("Department", titleFont));
	       
	       //Add ordered list
	       List orderedList = new List(List.ORDERED);
	       orderedList.add(new ListItem("Item 1"));
	       orderedList.add(new ListItem("Item 2"));
	       orderedList.add(new ListItem("Item 3"));
	       document.add(orderedList);
	    

	       
	       
	       
// CLOSE DOCUMENT
	       document.close();
	       writer.close();
	       
	       
	   } catch (Exception e) {
	       e.printStackTrace();
	   }

	   
	   
      
   }
}
