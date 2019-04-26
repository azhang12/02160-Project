package hospital;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;

public class Reader implements IReader{

	Reader(){}
	@Override
	public List<List<String>> read(String filename) {
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		
		
		try (CSVReader csvReader = new CSVReader(new FileReader(filename));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        listOfLists.add(Arrays.asList(values));
		    }
		    //RemoveCaptionsLine
		    listOfLists.remove(0);
		    return listOfLists;
		}
		    
		catch( IOException ex) {return null;}
		
	}
	
	public ArrayList<Staff> readStaff(List<Department> departmentList, String fileName)
	{
		ArrayList<Staff> staff = new ArrayList<Staff>();
		List<List<String>> listOfLists = this.read(fileName);
		
		for (List<String> i : listOfLists)
		{
			
			Department currentDep = Finder.findDepartment(i.get(2), departmentList);
			JobRole job = Finder.findJobRole(i.get(3));
			
			staff.add(new Staff(i.get(0), i.get(1), job, i.get(4), Integer.parseInt(i.get(5)),  new Access(), currentDep));
			
		}
		
		
		return staff;
	}
	
	public ArrayList <Department> readDepartment(String fileName){
		ArrayList<Department> departments = new ArrayList<Department>();
		List<List<String>> listOfLists = this.read(fileName);
		for (List<String> i : listOfLists){departments.add(new Department(i.get(0)));}
		
		return departments;
	}
	
	public ArrayList<Patient> readPatients (List<Department> departmentList, String fileName){
		ArrayList<Patient>  patients = new ArrayList<Patient>();
		List<List<String>> listOfLists = this.read(fileName);
		
		
		
		//ALL THE PROPERTIES OF PATIENTS ARE MISSING
		for (List<String> i :listOfLists)
		{
			Department currentDep = Finder.findDepartment(i.get(2), departmentList);
			patients.add(new Patient());
		}
		return patients;
	}
	
	

}



class Access{}


