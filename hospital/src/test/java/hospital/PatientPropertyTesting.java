package hospital;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatientPropertyTesting {
  Department dep = new Department("Department07");
  // note that birthday is stored as DD/MM/YYYY
  Patient instance = new Patient("Bill", "Smith", dep, "22/04/1998", "Elektrovej, Kongens Lyngby 2800, Denmark", "+45927564", true, 1, "Danish", 5, 7);

  @Test
  public void getBirthdayTest(){
    assertTrue(instance.getBirthday() == "22/04/1998");
  }
  @Test
  public void setBirthdayTest(){
    instance.setBirthday("24/05/1999");
    assertTrue(instance.getBirthday() == "24/05/1999");
  }
  @Test
  public void getAddressTest(){
    assertTrue(instance.getAddress() == "Elektrovej, Kongens Lyngby 2800, Denmark");
  }
  @Test
  public void setAddressTest(){
    instance.setAddress("Akademivej, Kongens Lyngby 2800, Denmark");
    assertTrue(instance.getAddress() == "Akademivej, Kongens Lyngby 2800, Denmark");
  }
  @Test
  public void getPhoneNumberTest(){
    assertTrue(instance.getPhoneNumber() = "+45927564");
  }
  @Test
  public void setPhoneNumberTest(){
    instance.setPhoneNumber("+45827394");
    assertTrue(instance.getPhoneNumber() == "+45827394");
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
    assertTrue(instance.getNationality() = "Danish");
  }
  @Test
  public void setNationalityTest(){
    instance.setNationality("Norwegian");
    assertTrue(instance.getNationality() == "Norwegian");
  }
  @Test
  public void getBedTest(){
    assertTrue(instance.getBed() == 5);
  }
  @Test
  public void setBedTest(){
    instance.setBed(8);
    assertTrue(instance.getBed() == 8);
  }
  @Test
  public void getQueueNumberTest(){
    assertTrue(instance.getQueueNumber() == 7);
  }
  @Test
  public void setQueueNumberTest(){
    instance.setQueueNumber(4);
    assertTrue(instance.getQueueNumber() == 4);
  }

}
