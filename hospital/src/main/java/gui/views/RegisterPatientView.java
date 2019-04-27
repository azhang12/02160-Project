package gui.views;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.controller.RegisterController;
import gui.utils.GridBagLayoutUtils;

public class RegisterPatientView extends JFrame implements IError {
	
private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnSave;
	private List <JTextField> txtEntries;
	private List<String> txtNames;
	private JCheckBox alive;
	private RegisterController controller;
	
	public RegisterPatientView(RegisterController controller) {
		this.controller=controller;
		this.txtEntries= new ArrayList<JTextField>();
		this.txtNames= new ArrayList<String>();
		
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Login");
		setLayout(new GridBagLayout());
		
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Date of Birth");
		txtNames.add("Nationality");
		txtNames.add("Address");
		txtNames.add("Phone Number");
		
		for ( int i=0; i<txtNames.size();++i) {
			this.txtEntries.add(new JTextField(20));
			add(new JLabel(txtNames.get(i)+":"), GridBagLayoutUtils.constraint(0, i, 5));
			add(txtEntries.get(txtEntries.size()-1), GridBagLayoutUtils.constraint(1, i, 5));
			
		}
		/*
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.validateInput(txtEntries);
			}
		});
		*/
		add(btnSave, GridBagLayoutUtils.constraint(1, txtEntries.size(), 5));
		
		pack();
		setLocationRelativeTo(null);
		
		
		
		
		
		
	}

	public void showError() {
		JOptionPane.showMessageDialog(this, "You are missing some Information", "Not saved", JOptionPane.ERROR_MESSAGE);
		
	}

}
