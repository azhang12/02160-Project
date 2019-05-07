package gui.views;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import gui.controller.AddPatientController;
import gui.controller.FilterPatientController;
import gui.model.Session;
import gui.utils.GridBagLayoutUtils;
import hospital.Patient;

public class FilterPatientView extends JFrame implements IError {
	
private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnSave;
	private List <JTextField> txtEntries;
	private List<String> txtNames;
	private FilterPatientController controller;
	
	public FilterPatientView(FilterPatientController controller) {
		this.controller = controller;
		this.txtEntries = new ArrayList<JTextField>();
		this.txtNames = new ArrayList<String>();
		
		initGUI();
	}
	
	private void initGUI() {
		
		setResizable(false);
		setTitle("Filter");
		setLayout(new GridBagLayout());
		
		txtNames.add("Patient ID");
		txtNames.add("First Name");
		txtNames.add("Last Name");
		txtNames.add("Department");
		txtNames.add("Birthday");
		txtNames.add("Address");
		txtNames.add("PhoneNumber");
		txtNames.add("Alive");
		txtNames.add("Nationality");
		txtNames.add("Bed No.");
		txtNames.add("Queue No.");
	
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
				controller.FilterPatientClicked(txtEntries);
			}
		});
		
		pack();
		setLocationRelativeTo(null);
	}
	
	public void showError() {
		JOptionPane.showMessageDialog(this, "No Matches", "Not saved", JOptionPane.ERROR_MESSAGE);
		
	}
	
}
