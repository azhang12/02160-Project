package gui.views;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import gui.controller.DataController;
import gui.controller.StaffDataController;
import gui.model.Session;


public class StaffDataView extends JFrame{
	
	
	private static final long serialVersionUID = 989075282041187452L;
	private StaffDataController controller;
	private JTable tblData;
	private JLabel lblSession;
	private String whatData;
	
	
	public StaffDataView(StaffDataController controller) {
		this.controller = controller;
		initGUI();
	}
	
	
	private void initGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Staff Data Manager");
		setPreferredSize(new Dimension(800, 600));
		
		//BUTTONS
		
		JButton btnAdd = new JButton("Add");
		JButton btnDelete = new JButton("Remove");
		JButton btnFind = new JButton("Filter");
		JButton btnStaff = new JButton("Staff");
		JButton btnPat = new JButton("Patients");
		JButton btnDep = new JButton("Departments");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.AddPersonClicked();
				
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.DeletePersonClicked(tblData.getSelectedRow());
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.FilterClicked();
			}
		});
		btnStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.ShowData("Staff");
			}
		});
		btnPat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.ShowData("Patients");
			}
		});
		btnDep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.ShowData("Departments");
			}
		});
		//Toolbar1
		JToolBar toolbar = new JToolBar();
		toolbar.add(btnStaff);
		toolbar.add(btnPat);
		toolbar.add(btnDep);
		add(toolbar, BorderLayout.SOUTH);
		
		
		//toolbar
				lblSession = new JLabel();
				lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
				
				JToolBar toolbar2 = new JToolBar();
				toolbar2.add(btnAdd);
				toolbar2.add(btnDelete);
				toolbar2.add(btnFind);
				toolbar2.add(Box.createHorizontalGlue());
				toolbar2.add(lblSession);
				add(toolbar2, BorderLayout.NORTH);
				
				
		//Add Table
				tblData = new JTable();
				tblData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tblData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						btnDelete.setEnabled((tblData.getSelectedRow() >= 0));
					}
				});
				add(new JScrollPane(tblData), BorderLayout.CENTER);
				
				pack();
				setLocationRelativeTo(null);
	
				
	}
	
	
	
	public void setTableModel(TableModel model) {
		tblData.setModel(model);
	}

	public void setSession(Session sessionModel) {
		lblSession.setText(sessionModel.getDepartment() +":   " + sessionModel.getRole() + "   ("+ sessionModel.getUserId()+")");
	}

	public void showError() {
		// TODO Auto-generated method stub
		
	}
	

}
