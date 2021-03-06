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
import gui.controller.FilterStaffController;
import gui.utils.GridBagLayoutUtils;

public class FilterStaffView extends JFrame implements IError {
	
private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnSave;
	private List <JTextField> txtEntries;
	private List<String> txtNames;
	private FilterStaffController controller;
	
	public FilterStaffView(FilterStaffController controller) {
		this.controller=controller;
		this.txtEntries= new ArrayList<JTextField>();
		this.txtNames= new ArrayList<String>();
		
		initGUI();
	}

	private void initGUI() {
		
		setResizable(false);
		setTitle("Filter");
		setLayout(new GridBagLayout());
		
		txtNames.add("Staff Number");
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Department Name");
		txtNames.add("Jobrole");
		txtNames.add("Email");
		
		for ( int i=0; i<txtNames.size();++i) {
			this.txtEntries.add(new JTextField(20));
			add(new JLabel(txtNames.get(i)+":"), GridBagLayoutUtils.constraint(0, i+1, 5));
			add(txtEntries.get(txtEntries.size()-1), GridBagLayoutUtils.constraint(1, i+1, 5));
			
		}
		
		
		
		//add a button.
		btnSave = new JButton("Search");
		btnSave.setBounds(50, 150, 100, 30);
		add(btnSave,GridBagLayoutUtils.constraint(0, 0, 5));
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.FilterStaffClicked(txtEntries);
			}
		});
		
		pack();
		setLocationRelativeTo(null);
		
		
		
		
		
	}
	

	public void showError() {
		JOptionPane.showMessageDialog(this, "No Matches", "Not saved", JOptionPane.ERROR_MESSAGE);
		
	}
	
	


}
