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
	private String whatData;
	
	public DataView(DataController controller) {
		this.controller = controller;
		initGUI();
		
		
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Data Manager");
		setPreferredSize(new Dimension(800, 600));
		
		//BUTTONS
		JButton btnNew = new JButton("Addd Item");
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addItem();
			}
		});
		
		JButton btnDelete = new JButton("Remove selected item");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.deleteItem(tblData.getSelectedRow());
			}
		});
		
		// toolbar
				lblSession = new JLabel();
				lblSession.setHorizontalAlignment(SwingConstants.RIGHT);
				
				JToolBar toolbar = new JToolBar();
				toolbar.add(btnNew);
				toolbar.add(btnDelete);
				toolbar.add(Box.createHorizontalGlue());
				toolbar.add(lblSession);
				add(toolbar, BorderLayout.NORTH);
				
		// table
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
		lblSession.setText("<html>" + sessionModel.getUserId() + " <i>(" + sessionModel.getRole() + ")</i></html>");
	}
	

}
