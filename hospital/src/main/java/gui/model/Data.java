package gui.model;

import javax.swing.table.AbstractTableModel;

import hospital.Hospital;

public class Data extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	private Hospital hospital;
	
	
	public Data() {
		
		hospital = new Hospital();
		
	}
	
	


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
