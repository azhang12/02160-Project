package hospital;

import java.util.LinkedList;
import java.util.Queue; 

public class OutpatientDepartment extends Department {
	
	Queue<Patient> outPatientQueue = new LinkedList<Patient>();
	
	public boolean addToQueue(Patient newPatient) {
		return this.outPatientQueue.add((newPatient);
	}
	
	public Patient removeFromQueue(Patient newPatient) {
		return this.outPatientQueue.poll();
	}
	
	public Queue<Patient> getQueue() {
		return outPatientQueue;
	}
}
