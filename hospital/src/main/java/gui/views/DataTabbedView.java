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


public class DataTabbedView extends JFrame{
	JComponent panel1 = makeTextPanel("Panel #1");
	tabbedPane.addTab("Tab 1", icon, panel1,
	                  "Does nothing");
	tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	
	private JComponent panel1 = 
	private JComponent panel2;
	private JComponent panel3;
	
	

}
