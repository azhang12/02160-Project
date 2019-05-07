
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
 /*

package gui.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.controller.EditPatientController;
import hospital.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPatientView extends JFrame {

	private JPanel contentPane;
	private JTextField displayFirstName;
	private JTextField displayLastName;
	private JTextField displayBirthday;
	private JTextField displayAddress;
	private JTextField displayPhoneNumber;
	private JTextField displayNationality;
	private JTextField textNationality;
	private JTextField textPhoneNumber;
	private JTextField textAddress;
	private JTextField textBirthday;
	private JTextField textLastName;
	private JTextField textFirstName;
	private JButton btnSave;
	private List <JTextField> txtEntries;
	private List<String> txtNames;
	Patient patient;
	private EditPatientController controller;
	private JTextField displayStatus;
	private JTextField textStatus;
	private JLabel lblAliveDead;
	private JButton btnCancle;
	
	
	public EditPatientView(EditPatientController controller, Patient patientToChange) {
		
		this.controller=controller;
		this.txtEntries= new ArrayList<JTextField>();
		this.txtNames= new ArrayList<String>();
		this.patient=patientToChange;
		initGUI();
	}



	
	 //Create the frame.
	 
	private void initGUI() {
		setTitle("Edit Patient");
		setBounds(100, 100, 635, 394);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblF = new JLabel("First Name");
		lblF.setFont(new Font("Arial", Font.PLAIN, 15));
		lblF.setBounds(14, 20, 95, 18);
		contentPane.add(lblF);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLastName.setBounds(14, 60, 95, 18);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Birthday");
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAddress.setBounds(14, 100, 95, 18);
		contentPane.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAddress_1.setBounds(14, 140, 95, 18);
		contentPane.add(lblAddress_1);
		
		JLabel lblPhoneNumer = new JLabel("Phone Numer");
		lblPhoneNumer.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPhoneNumer.setBounds(14, 180, 120, 18);
		contentPane.add(lblPhoneNumer);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNationality.setBounds(14, 220, 100, 18);
		contentPane.add(lblNationality);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 15));
		lblStatus.setBounds(14, 260, 100, 18);
		contentPane.add(lblStatus);
		
		displayFirstName = new JTextField();
		displayFirstName.setText(patient.getFirstName());
		displayFirstName.setEditable(false);
		displayFirstName.setFont(new Font("Arial", Font.PLAIN, 13));
		displayFirstName.setBounds(150, 20, 210, 24);
		contentPane.add(displayFirstName);
		displayFirstName.setColumns(10);
		
		displayLastName = new JTextField();
		displayLastName.setText(patient.getLastName());
		displayLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		displayLastName.setEditable(false);
		displayLastName.setColumns(10);
		displayLastName.setBounds(150, 60, 210, 24);
		contentPane.add(displayLastName);
		
		displayBirthday = new JTextField();
		displayBirthday.setText(patient.getBirthday());
		displayBirthday.setFont(new Font("Arial", Font.PLAIN, 13));
		displayBirthday.setEditable(false);
		displayBirthday.setColumns(10);
		displayBirthday.setBounds(150, 100, 210, 24);
		contentPane.add(displayBirthday);
		
		displayAddress = new JTextField();
		displayAddress.setText(patient.getAddress());
		displayAddress.setFont(new Font("Arial", Font.PLAIN, 13));
		displayAddress.setEditable(false);
		displayAddress.setColumns(10);
		displayAddress.setBounds(150, 140, 210, 24);
		contentPane.add(displayAddress);
		
		displayPhoneNumber = new JTextField();
		displayPhoneNumber.setText(patient.getPhoneNumber());
		displayPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 13));
		displayPhoneNumber.setEditable(false);
		displayPhoneNumber.setColumns(10);
		displayPhoneNumber.setBounds(150, 180, 210, 24);
		contentPane.add(displayPhoneNumber);
		
		displayNationality = new JTextField();
		displayNationality.setText(patient.getNationality());
		displayNationality.setFont(new Font("Arial", Font.PLAIN, 13));
		displayNationality.setEditable(false);
		displayNationality.setColumns(10);
		displayNationality.setBounds(150, 220, 210, 24);
		contentPane.add(displayNationality);
		
		
		displayStatus = new JTextField();
		String isAlive;
		if(patient.getAlive()) {
			isAlive = "Alive";
		} else {
			isAlive = "Dead";
		}
		displayStatus.setText(isAlive);
		displayStatus.setFont(new Font("Arial", Font.PLAIN, 13));
		displayStatus.setEditable(false);
		displayStatus.setColumns(10);
		displayStatus.setBounds(150, 260, 210, 24);
		contentPane.add(displayStatus);
		
		
		
		
		// inputs
		
		textNationality = new JTextField();
		textNationality.setFont(new Font("Arial", Font.PLAIN, 13));
		textNationality.setColumns(10);
		textNationality.setBounds(393, 220, 210, 24);
		contentPane.add(textNationality);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 13));
		textPhoneNumber.setColumns(10);
		textPhoneNumber.setBounds(393, 180, 210, 24);
		contentPane.add(textPhoneNumber);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Arial", Font.PLAIN, 13));
		textAddress.setColumns(10);
		textAddress.setBounds(393, 140, 210, 24);
		contentPane.add(textAddress);
		
		textBirthday = new JTextField();
		textBirthday.setFont(new Font("Arial", Font.PLAIN, 13));
		textBirthday.setColumns(10);
		textBirthday.setBounds(393, 100, 210, 24);
		contentPane.add(textBirthday);
		
		textLastName = new JTextField();
		textLastName.setFont(new Font("Arial", Font.PLAIN, 13));
		textLastName.setColumns(10);
		textLastName.setBounds(393, 60, 210, 24);
		contentPane.add(textLastName);
		
		textFirstName = new JTextField();
		textFirstName.setFont(new Font("Arial", Font.PLAIN, 13));
		textFirstName.setColumns(10);
		textFirstName.setBounds(393, 20, 210, 24);
		contentPane.add(textFirstName);
		
		textStatus = new JTextField();
		textStatus.setFont(new Font("Arial", Font.PLAIN, 13));
		textStatus.setColumns(10);
		textStatus.setBounds(393, 260, 210, 24);
		contentPane.add(textStatus);
		
		
		// button
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// save inputs in txtEntries
				txtEntries.add(textFirstName);
				txtEntries.add(textLastName);
				txtEntries.add(textBirthday);
				txtEntries.add(textAddress);
				txtEntries.add(textPhoneNumber);
				txtEntries.add(textNationality);
				txtEntries.add(textStatus);
				controller.editPatientClicked(patient,txtEntries);
			}
		});
		
		btnSave.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSave.setBounds(431, 320, 77, 27);
		contentPane.add(btnSave);
		
		lblAliveDead = new JLabel("* Alive / Dead");
		lblAliveDead.setFont(new Font("Arial", Font.PLAIN, 13));
		lblAliveDead.setBounds(393, 285, 146, 18);
		contentPane.add(lblAliveDead);
		
		btnCancle = new JButton("Cancle");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.editPatientClose();
			}
		});
		btnCancle.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCancle.setBounds(526, 320, 77, 27);
		contentPane.add(btnCancle);
		
		
		
		
	}
	
	public void showError(String errorText) {
		JOptionPane.showMessageDialog(this, errorText, "Not saved", JOptionPane.ERROR_MESSAGE);
		
	}
}
*/

