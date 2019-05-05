package hospital;

import java.util.ArrayList;
import java.util.List;


//Part of the Observer Pattern
public interface ISubject {
	
	//Contains all Oberservs
	public void registerObserver(IObserver observer);
	public void unregisterObserver(IObserver observer);
	
	//Notifies Oberserver
	public void notifyObserver();
	public void updateObserverList();

}
