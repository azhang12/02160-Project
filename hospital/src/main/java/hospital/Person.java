// Eunjin Yoo

package hospital;
import java.util.*;

public abstract class Person implements ISubject {
	
	protected String firstName;
	protected String lastName;
	protected Department department;
	protected List<IObserver> observers;
	
	public Person() {}
	public Person(String _firstName, String _lastName, Department _department) {
		firstName = _firstName;
		lastName = _lastName;
		department = _department;
		observers = new ArrayList<IObserver>();
		this.registerObserver(_department);
		notifyObserver();
	}
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String n) {
		firstName = n;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String n) {
		lastName = n;
	}
	
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department d) {
		department = d;
		notifyObserver();
	}
	public List<IObserver> getObservers(){
		return this.observers;
	}
	
	public void setObservers(List<IObserver> newObserverList) {
		this.observers=newObserverList;
	}
	
	@Override
		public void registerObserver(IObserver observer) {
			observers.add(observer);
		}
	@Override
		public void unregisterObserver(IObserver observer) {
			int indexObs = observers.indexOf(observer);
			if(indexObs !=-1) {
				observers.remove(indexObs);
			}
		}
		
	@Override
		public void notifyObserver() {
			for (IObserver obs: observers) {
				obs.update(this);
			}
			
		}
	
	

}
