package hospital;

import java.util.Queue; 

public class OutpatientDepartment extends Department {
	
	Queue<Patient> outPatientQueue = new Queue<Patient>();
	
	public boolean addToQueue(Patient newPatient) {
		return this.outPatientQueue.push(newPatient);
	}
	
	public Patient removeFromQueue(Patient newPatient) {
		return this.outPatientQueue.pop();
	}
	
	public Queue<Patient> getQueue(Patient newPatient) {
		return outPatientQueue;
	}
}
