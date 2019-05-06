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
import javax.swing.JComboBox;

import gui.controller.AddStaffController;
import gui.utils.GridBagLayoutUtils;
import hospital.Hospital;
import hospital.JobRole;

public class AddStaffView extends JFrame implements IError {
	
private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnSave;
	private List <JTextField> txtEntries;
	private List<String> txtNames;
	private AddStaffController controller;
	private String[] depCombo;
	private String[] jobCombo;
	private List<String> inputValues;
	private JComboBox<String> jobComboBox;
	private JComboBox<String> depComboBox;
	
	public AddStaffView(AddStaffController controller) {
		this.controller=controller;
		this.txtEntries= new ArrayList<JTextField>();
		this.txtNames = new ArrayList<String>();
		this.depCombo = new String[Hospital.getDepartment().size() + 1];
		this.jobCombo = new String[JobRole.values().length + 1];
		this.inputValues = new ArrayList<String>();
		
		initGUI();
	}
	
	private void initGUI() {
		
		setResizable(false);
		setTitle("Add Staff Member");
		setLayout(new GridBagLayout());
		
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Department Name");
		txtNames.add("Job Role");
		
		// adding text names for label names
		for (int i = 0; i < txtNames.size(); ++i) {
			add(new JLabel(txtNames.get(i)+":"), GridBagLayoutUtils.constraint(0, i, 5));
		}
		
		// defining an array with the vertical index of each input type:
		int[] text = {0, 1};
		
		for ( int i=0; i < text.length;++i) {
			this.txtEntries.add(new JTextField(20));
			add(txtEntries.get(i), GridBagLayoutUtils.constraint(1, text[i], 5));
		}
		
		// department combo box
		this.depCombo[0] = "Make selection";
		for (int i = 1; i < depCombo.length; i++) {
			this.depCombo[i] = Hospital.getDepartment().get(i - 1).getName();
		}
		depComboBox = new JComboBox<>(depCombo);

		// job role combo box
		this.jobCombo[0] = "Make selection";
		for (int i = 1; i < jobCombo.length; i++) {
			this.jobCombo[i] = JobRole.values()[i - 1].toString();
		}
		jobComboBox = new JComboBox<>(jobCombo);
		
		// placing combo boxes
		add(depComboBox, GridBagLayoutUtils.constraint(1, 2, 5));
		add(jobComboBox, GridBagLayoutUtils.constraint(1, 3, 5));
		
		//add a button.
		btnSave = new JButton("Add");
		btnSave.setBounds(50, 150, 100, 30);
		add(btnSave,GridBagLayoutUtils.constraint(1, txtNames.size(), 5));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inputValues.add(txtEntries.get(0).getText());
				inputValues.add(txtEntries.get(1).getText());
				inputValues.add((String)depComboBox.getSelectedItem());
				inputValues.add((String)jobComboBox.getSelectedItem());
				
				controller.addStaffClicked(inputValues, txtNames);
			}
		});
		pack();
		setLocationRelativeTo(null);
	}
	
	public void showError(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	public void showError() {
		JOptionPane.showMessageDialog(this, "Error occured", "Error", JOptionPane.ERROR_MESSAGE);
		
	}


}
