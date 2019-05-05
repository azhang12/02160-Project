package hospital;

public interface IObserver {
	//Change input???
	
	public void update(Person subjectToUpdate);
	

}
//When Staff changes-> others have to be notified
//Staff/Patiens are the publisher / subject
// Departments, beds, ... are Listeners/ observers