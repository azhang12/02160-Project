package hospital;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatientPropertyTesting {
  Department dep1 = new InpatientDepartment("Department07",4);
  Bed bed1 = new Bed();
  Bed bed2 = new Bed();

  // note that birthday is stored as DD/MM/YYYY
  Patient instance = new Patient("Bill", "Smith", dep1, "22/04/1998", "Elektrovej, Kongens Lyngby 2800, Denmark", "+45927564", true, 1, "Danish", null, 0);

  @Test
  public void getBirthdayTest(){
    assertTrue(instance.getBirthday().equals("22/04/1998"));
  }
  @Test
  public void setBirthdayTest(){
    instance.setBirthday("24/05/1999");
    assertTrue(instance.getBirthday().equals("24/05/1999"));
  }
  @Test
  public void getAddressTest(){
    assertTrue(instance.getAddress().contentEquals("Elektrovej, Kongens Lyngby 2800, Denmark"));
  }
  @Test
  public void setAddressTest(){
    instance.setAddress("Akademivej, Kongens Lyngby 2800, Denmark");
    assertTrue(instance.getAddress().contentEquals("Akademivej, Kongens Lyngby 2800, Denmark"));
  }
  
  @Test
  public void getPhoneNumberTest(){
    assertTrue(instance.getPhoneNumber().equals("+45927564"));
  }
  @Test
  public void setPhoneNumberTest(){
    instance.setPhoneNumber("+45827394");
    assertTrue(instance.getPhoneNumber().contentEquals("+45827394"));
  }
  @Test
  public void getAliveTest(){
    assertTrue(instance.getAlive() == true);
  }
  @Test
  public void setAliveTest(){
    instance.setAlive(false);
    assertTrue(instance.getAlive() == false);
  }
  @Test
  public void getPatientNumberTest(){
    assertTrue(instance.getPatientNumber() == 1);
  }
  @Test
  public void getNationalityTest(){
    assertTrue(instance.getNationality().contentEquals("Danish"));
  }
  @Test
  public void setNationalityTest(){
    instance.setNationality("Norwegian");
    assertTrue(instance.getNationality().contentEquals("Norwegian"));
  }
  
 
  
  @Test
  public void setGetBedTest(){
	Bed bed3 = ((InpatientDepartment)dep1).getBed().get(0);
	instance.setBed(bed3,true);
    assertTrue(instance.getBed() == bed3);
  }
  
  @Test
  public void getQueueNumberTest(){
    assertTrue(instance.getQueueNumber() == 0);
  }
  @Test
  public void setQueueNumberTest(){
    instance.setQueueNumber(4);
    assertTrue(instance.getQueueNumber() == 4);
    assertTrue(instance.getQueueNumber() == 4);
  }

}
