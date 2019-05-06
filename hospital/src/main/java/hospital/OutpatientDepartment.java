package hospital;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue; 

public class OutpatientDepartment extends Department {
	

	public OutpatientDepartment(String name) {
		super(name);
		
	}

	Queue<Patient> outPatientQueue = new LinkedList<Patient>();
	
	public boolean addToQueue(Patient newPatient) {
		return this.outPatientQueue.offer(newPatient);
	}
	
	public Patient removeFromQueue(Patient newPatient) {
		return this.outPatientQueue.poll();
	}
	
	public Queue<Patient> getQueue() {
		return outPatientQueue;
	}
	
	@Override
	public void updateQueue(){
		
		for (int i=0; i<admittedPatients.size();++i) {
			admittedPatients.get(i).setQueueNumber(i+1);
			outPatientQueue.clear();
			outPatientQueue.add(admittedPatients.get(i));
		}
			
	}
}