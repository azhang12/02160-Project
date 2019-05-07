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

import gui.controller.AddPatientController;
import gui.utils.GridBagLayoutUtils;


public class AddPatientView extends JFrame implements IError {
	
private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnSave;
	private List <JTextField> txtEntries;
	private List<String> txtNames;
	private AddPatientController controller;
	
	public AddPatientView(AddPatientController controller) {
		this.controller=controller;
		this.txtEntries= new ArrayList<JTextField>();
		this.txtNames= new ArrayList<String>();
		
		initGUI();
	}
	
	private void initGUI() {
		
		setResizable(false);
		setTitle("Add Patient");
		setLayout(new GridBagLayout());
		
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Birthday");
		txtNames.add("Address");
		txtNames.add("Phone Number");
		txtNames.add("Alive");
		txtNames.add("Nationality");
		
		// adding labels	
		for ( int i=0; i<txtNames.size();++i) {			
			add(new JLabel(txtNames.get(i)+":"), GridBagLayoutUtils.constraint(0, i, 5));
		}
		
		// defining an array with the vertical index of each input type:
		
		
		// adding text fields
		for ( int i=0; i < txtNames.size();++i) {
			this.txtEntries.add(new JTextField(20));
		}
		
		// create radio buttons for alive/not alive
		//JRadioButton yesButton = new JRadioButton("Yes", true);
		//JRadioButton noButton = new JRadioButton("No", false);
		
		// grouping radio buttons
		//ButtonGroup bgroup = new ButtonGroup();
		//bgroup.add(yesButton);
		//bgroup.add(noButton);
		
		// adding radio buttons horizontally in a panel
		//JPanel radioPanel = new JPanel();
		//radioPanel.setLayout(new GridLayout(1,2));
		//radioPanel.add(yesButton);
		//radioPanel.add(noButton);	
		
		// placement of input based on arrays above
		for (int i = 0; i < txtEntries.size(); i++) { // text fields and associated exclamations
			add(txtEntries.get(i), GridBagLayoutUtils.constraint(1, i, 5));
		}
		
		//for (int i = 0; i < radio.length; i++) { // radio buttons
			//add(radioPanel, GridBagLayoutUtils.constraint(1, radio[i], 5)); // alive (radio buttons)
		//}
		
		// add a button
		btnSave = new JButton("Save");
		btnSave.setBounds(50, 150, 100, 30);
		add(btnSave,GridBagLayoutUtils.constraint(1, txtNames.size(), 5));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addPatientClicked(txtEntries); // also manually set as entry types vary. refer to above
			}
		});
		
		pack();
		setLocationRelativeTo(null);
	}

	public void showError() {
		JOptionPane.showMessageDialog(this, "You are missing some Information", "Not saved", JOptionPane.ERROR_MESSAGE);
		
	}
	public void showError(String error) {
		JOptionPane.showMessageDialog(this, error, "Not saved", JOptionPane.ERROR_MESSAGE);
		
	}
}
