package gui.views;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.controller.EditPatientController;
import gui.controller.EditStaffController;
import gui.utils.GridBagLayoutUtils;
import hospital.Finder;
import hospital.Patient;
import hospital.Staff;


public class EditPatientView extends JFrame implements IError {
	
private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnSave;
	private List <JTextField> txtEntries;
	private List<String> txtNames;
	Patient patient;
	private EditPatientController controller;
	
	public EditPatientView(EditPatientController controller, Patient patientToChange) {
		
		this.controller = controller;
		this.txtEntries = new ArrayList<JTextField>();
		this.txtNames = new ArrayList<String>();
		this.patient=patientToChange;
		initGUI();
	}
	
	private void initGUI() {
		
		
		setResizable(false);
		setTitle("Edit Patient");
		setLayout(new GridBagLayout());
		
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Birthday");
		txtNames.add("Address");
		txtNames.add("Phone Number");
		txtNames.add("Living");
		txtNames.add("Nationality");
		List<String> patientInfoOld = new ArrayList<String>();
		patientInfoOld.add(patient.getFirstName());
		patientInfoOld.add(patient.getLastName());
		patientInfoOld.add(patient.getBirthday());
		patientInfoOld.add(patient.getAddress());
		patientInfoOld.add(patient.getPhoneNumber());
		patientInfoOld.add(patient.getAlive().toString());
		patientInfoOld.add(patient.getNationality());
			
		
		for ( int i=0; i < txtNames.size();++i) {
			this.txtEntries.add(new JTextField(20));
			add(new JLabel(txtNames.get(i)+":"), GridBagLayoutUtils.constraint(0, i, 5));
			add(new JLabel (patientInfoOld.get(i)), GridBagLayoutUtils.constraint(1, i, 5));
			add(txtEntries.get(txtEntries.size()-1), GridBagLayoutUtils.constraint(2, i, 5));
		}
		
		
		//add a button.
		btnSave = new JButton("Save");
		btnSave.setBounds(50, 150, 100, 30);
		add(btnSave,GridBagLayoutUtils.constraint(1, txtEntries.size(), 5));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.editPatientClicked(patient,txtEntries);
			}
		});
		pack();
		setLocationRelativeTo(null);
	}

	public void showError(String errorText) {
		JOptionPane.showMessageDialog(this, errorText, "Not saved", JOptionPane.ERROR_MESSAGE);
		
	}

	@Override
	public void showError() {
		// TODO Auto-generated method stub
		
	}
	
}

