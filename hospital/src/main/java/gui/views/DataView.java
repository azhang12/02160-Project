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
import gui.model.Session;


public class DataView extends JFrame{
	
	
	private static final long serialVersionUID = 989075282041187452L;
	private DataController controller;
	private JTable tblData;
	private JLabel lblSession;
	private JToolBar toolBarData;
	private JToolBar toolBarOperations;
	private JButton btnAddStaff = new JButton("Add Staff");
	private JButton btnAddPatient = new JButton("Add Patient");
	private JButton btnDeleteStaff = new JButton("Remove Staff");
	private JButton btnDeletePatient = new JButton("Remove Patient");
	private JButton btnAddDepartment= new JButton("Add Department");
	private JButton btnDeleteDepartment = new JButton("Remove Department");
	private JButton btnFindStaff = new JButton("Filter");
	private JButton btnFindPatients = new JButton("Filter");
	private JButton btnFindDepartments = new JButton("Filter");
	private JButton btnStaff = new JButton("Staff");
	private JButton btnPat = new JButton("Patients");
	private JButton btnDep = new JButton("Departments");
	private JButton btnEditPatient = new JButton("Edit");
	private JButton btnEditStaff = new JButton("Edit");
	
	
	private JButton btnAdmitPatient = new JButton("Admit");
	private JButton btnDischargePatient = new JButton("Discharge");
	private JButton btnCallPatient = new JButton ("Call");
	private JButton btnChangeDepartment = new JButton ("Change Department");
	private JButton btnChangeBed= new JButton ("Change Bed");
	
	
	
	public DataView(DataController controller) {
		this.controller = controller;
		initGUI();
	}
	
	
	private void initGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Staff Data Manager");
		setPreferredSize(new Dimension(800, 600));
		
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
		
		//BUTTO LISTENERS FOR ALL STAFF OPERATIONS
		btnAddStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.AddPersonClicked("Staff");
			}
		});
		btnDeleteStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.DeletePersonClicked(tblData.getSelectedRow());
			}
		});
		
		btnFindStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.FilterClicked();
			}
		});
		btnEditStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.EditClicked();
			}
		});
		
		//BUTTON LISTENERS FOR ALL PATIENT OPERATIONS
		btnAddPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.AddPersonClicked("Patient");
			}
		});
		btnDeletePatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.DeletePersonClicked(tblData.getSelectedRow());
			}
		});
		
		btnFindPatients.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.FilterClicked();
			}
		});
		
		btnEditPatient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.EditClicked();
			}
		});
		
		//BUTTON LISTENERS FOR ALL DEPARTMENT OPERATIONS
		
		btnAddDepartment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				controller.AddPersonClicked("Department");
			}
		});
		btnDeleteDepartment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.DeletePersonClicked(tblData.getSelectedRow());
			}
		});
		
		btnFindDepartments.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.FilterClicked();
			}
		});
		
		
		
		//Toolbar1
		toolBarData= new JToolBar();
		toolBarData.add(btnStaff);
		toolBarData.add(btnPat);
		toolBarData.add(btnDep);
		add(toolBarData, BorderLayout.SOUTH);
		
		
		//ToolBar2
		
		lblSession = new JLabel();
		lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
		toolBarOperations= new JToolBar();
		add(toolBarOperations, BorderLayout.NORTH);
				
				
		//Add Table
				tblData = new JTable();
				tblData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tblData.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						btnDeleteStaff.setEnabled((tblData.getSelectedRow() >= 0));
					}
				});
				add(new JScrollPane(tblData), BorderLayout.CENTER);
				
				pack();
				setLocationRelativeTo(null);
	
				
	}
	
	
	
	public void setTableModel(TableModel model,String data) {
		showAvailableOperations(data);
			
		tblData.setModel(model);
		
	}

	public void setSession(Session sessionModel) {
		lblSession.setText(sessionModel.getDepartment() +":   " + sessionModel.getRole() + "   ("+ sessionModel.getUserId()+")");
	}

	public void showError() {
		// TODO Auto-generated method stub
		
	}
	
	public void showAvailableOperations(String input) {
		
		if(input.equals("Staff")) {
			//toolbar Staff
			
			toolBarOperations.removeAll();
			
		
			toolBarOperations.add(btnAddStaff);
			toolBarOperations.add(btnDeleteStaff);
			toolBarOperations.add(btnFindStaff);
			toolBarOperations.add(btnEditStaff);
			toolBarOperations.add(Box.createHorizontalGlue());
			toolBarOperations.add(lblSession);
			//add(toolBarOperations, BorderLayout.NORTH);	
			toolBarOperations.repaint();
		}
		else if(input.equals("Patients")) {
			//toolbar Patients
		
			toolBarOperations.removeAll();
			
		
			toolBarOperations.add(btnAddPatient);
			toolBarOperations.add(btnDeletePatient);
			toolBarOperations.add(btnFindPatients);
			toolBarOperations.add(btnEditPatient);
			toolBarOperations.add(btnAdmitPatient );
			toolBarOperations.add(btnDischargePatient);
			toolBarOperations.add(btnCallPatient);
			toolBarOperations.add(btnChangeDepartment);
			toolBarOperations.add(btnChangeBed);
			toolBarOperations.add(Box.createHorizontalGlue());
			toolBarOperations.add(lblSession);
			//add(toolBarOperations, BorderLayout.NORTH);
			toolBarOperations.repaint();
		}
		
		
		
		else {
			
			//toolbar Departments
				
				toolBarOperations.removeAll();
			
				toolBarOperations.add(btnAddDepartment);
				toolBarOperations.add(btnDeleteDepartment);
				toolBarOperations.add(btnFindDepartments);
				toolBarOperations.add(Box.createHorizontalGlue());
				toolBarOperations.add(lblSession);
				//add(toolBarOperations, BorderLayout.NORTH);
				toolBarOperations.repaint();
			
		}
	
	
	}

	

}
