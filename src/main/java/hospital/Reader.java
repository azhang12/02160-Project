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
			
			
			Staff newStaff = (new Staff(i.get(0), i.get(1), job, i.get(4), Integer.parseInt(i.get(5)),  new Access(), currentDep));
			staff.add(newStaff);
			currentDep.addStaff(newStaff);
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
			String fName = i.get(0);
			String lName = i.get(1);
			String dep = i.get(2);
			String birth = i.get(3);
			String address = i.get(4);
			String phone = i.get(5);
			boolean alive = true;
			if(i.get(6)!="yes") {alive=false;}
			int patientNumber = Integer.parseInt(i.get(7));
			String nation = i.get(8);
			int bedNumber = Integer.parseInt(i.get(9));
			int queueNumber = Integer.parseInt(i.get(10));
			
			
			Department currentDep = Finder.findDepartment(dep, departmentList);
			Patient pat = (new Patient(fName,lName,currentDep,birth,address,phone,alive,patientNumber,nation,null,0));
			
			//Identify the bed or queue number
			if (currentDep!=null) {
				if(bedNumber!=0&&queueNumber==0) {
					
					Bed b = Finder.findBed(bedNumber, ((InpatientDepartment) currentDep).getBed());
					pat.setBed(b);
				}
				else if (bedNumber==0&&queueNumber!=0) {
					pat.setQueueNumber(queueNumber);
				}
				
				
			}
			patients.add(pat);
				
		}
		return patients;
	}
	
	

}



class Access{}


