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
			for (Object d : inputList) {
				List<String> s = new ArrayList<String>();
				s.add(((Department) d).getName());
				listOfLists.add(s);
			}
		}
		else if (inputList.get(0) instanceof Staff) {
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
