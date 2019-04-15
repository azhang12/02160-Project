package hospital;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
class Staff{};
public class Reader implements IReader{

	
	@Override
	public List<List<String>> read(String filename) {
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		List<String> list1 = new ArrayList<String>();
		list1.add("Delhi");
		list1.add("Mumbai");
		
		try (CSVReader csvReader = new CSVReader(new FileReader("book.csv"));) {
		    String[] values = null;
		    while ((values = csvReader.readNext()) != null) {
		        listOfLists.add(Arrays.asList(values));
		    }
		    return listOfLists;
		}
		    
		catch( IOException ex) {
			return null;
			
		}
		
	}
	public List<Staff> readStaff(String fileName)
	{
		List<Staff> staff = new ArrayList<Staff>();
		List<List<String>> listOfLists = this.read(fileName);
		
		for (List<String> i : listOfLists)
		{
			//Identify jobRole
			//Identify Department
			
			staff.add(new Staff(i.get(0), i.get(1), new jobRole(), i.get(4),Integer.parseInt(i.get(5)),  new Access(), new Department()));
			
			
			
		}
		
		
		return staff;
		
	}
	

}
