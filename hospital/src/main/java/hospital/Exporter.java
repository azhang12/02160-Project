package hospital;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Exporter {
	
	
	public boolean export(List<?> inputList, String outputFileName) {
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		if(inputList.get(0) instanceof Department) {
			List<String> cNames = new ArrayList<String>();
			cNames.add("Department Name");
			cNames.add("Inpatient");
			cNames.add("No. of Beds");
			listOfLists.add(cNames);
			
			
			for (Object d : inputList) {
				List<String> s = new ArrayList<String>();
				s.add(((Department) d).getName());
				if(d instanceof InpatientDepartment ) {
					s.add("yes");
					s.add(Integer.toString(((InpatientDepartment) d).getBed().size()));					
				}
				else {
					s.add("no");
					s.add("0");
					
				}
				listOfLists.add(s);
			}
		}
		else if (inputList.get(0) instanceof Staff) {
			List<String> cNames = new ArrayList<String>();
			cNames.add("First Name");
			cNames.add("Last Name");
			cNames.add("Department");
			cNames.add("Job Role");
			cNames.add("eMail");
			cNames.add("Staff No");
			cNames.add("accesLevel");
			listOfLists.add(cNames);
			for (Object d : inputList) {
				List<String> s = new ArrayList<String>();
				s.add(((Staff) d).getFirstName());
				s.add(((Staff) d).getLastName());
				s.add(((Staff) d).getDepartment().getName());
				s.add(((Staff) d).getJobRole().toString());
				s.add(((Staff) d).getEmail());
				int num = ((Staff) d).getStaffNumber();
				s.add(Integer.toString(num));
				s.add(((Staff) d).getAccessLevel().toString());
				listOfLists.add(s);
			}
		}
		else if (inputList.get(0) instanceof Patient) {
			List<String> cNames = new ArrayList<String>();
			cNames.add("First Name");
			cNames.add("Last Name");
			cNames.add("Department");
			cNames.add("Birthday");
			cNames.add("Address");
			cNames.add("phone");
			cNames.add("Alive");
			cNames.add("Patient Number");
			cNames.add("Nationality");
			cNames.add("Bed Number");
			cNames.add("Queue Number");
			listOfLists.add(cNames);
			for (Object d : inputList) {
				List<String> s = new ArrayList<String>();
				
		
				s.add(((Patient) d).getFirstName());
				s.add(((Patient) d).getLastName());
				if(((Patient) d).getDepartment()!=null) {
					s.add(((Patient) d).getDepartment().getName());
				}
				else {s.add("");}
						
						
				s.add(((Patient)d).getBirthday());
				s.add(((Patient)d).getAddress());
				s.add(((Patient)d).getPhoneNumber());
				if(((Patient)d).getAlive()) {
					s.add("yes");
				}
				else {
					s.add("no");
				}
				int num = ((Patient) d).getPatientNumber();
				s.add(Integer.toString(num));
				s.add(((Patient) d).getNationality());
				
				if(((Patient)d).getDepartment() instanceof InpatientDepartment){
					int bedNo = ((Patient)d).getBed().getId();
					s.add(Integer.toString(bedNo));
					s.add("0");
				}
				else if (((Patient)d).getDepartment() instanceof OutpatientDepartment) {
					int qNo = ((Patient)d).getQueueNumber();
					
					s.add("0");
					s.add(Integer.toString(qNo));
				}
				else {
					s.add("0");
					s.add("0");
				}
				
				
				listOfLists.add(s);
			}
			
		}
				
				
		
		else {
			
		}
		
			
		
		return this.print(listOfLists,outputFileName);
		

	}
	
	
	
	
	private boolean print(List<List<String>> listOfLists,String outputFileName) {
		String file = outputFileName.substring(outputFileName.length()-4);
		String test = ".csv";
		if(!file.equals(test)) {return false;}
		
		try (FileWriter csvWriter = new FileWriter(outputFileName); ) {
			for (List<String> list : listOfLists) {
				
				for ( int m = 0; m<list.size();++m) {
					csvWriter.append(list.get(m));
					if ( m<list.size()-1) {csvWriter.append(',');}
				}
				csvWriter.append('\n');
				
			}
			csvWriter.flush();  
			csvWriter.close();  
			return true;
		}
		    
		catch( IOException ex) {return false;}
	}

}
