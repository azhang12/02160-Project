package gui.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import hospital.Department;
import hospital.Hospital;
import hospital.InpatientDepartment;

public class Data extends AbstractTableModel {
	private static final long serialVersionUID = -8100080945080186023L;
	private Hospital hospital;
	
	
	public Data() {
		
		hospital = new Hospital();
		
	}
	
	public Data(Hospital h) {
		this.hospital=h;
	}
	
	public Hospital getData()
	{ return this.hospital;}
	


	@Override
	public int getColumnCount() {
		return 2; // this is fixed: product and quantity
	}

	@Override
	public int getRowCount() {
		return 12;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column == 0) {
			return "Product name";
		} else if (column == 1) {
			return "Quantity";
		}
		return null;
	}
	
	public void updateView( String s)
	{
		switch(s) {
		case "Departments":
			
			
			List<Department> dep = this.hospital.getDepartment();
			
			this.addColumn("DepartmentName");
			d.addColumn("InpatientDepartment");
			d.addColumn("OutpatientDepartment");
			d.addColumn("Number of Patients");
			d.addColumn("No. of Beds");
			d.addColumn("No. of Beds occupied");
			
			for (Department i : dep) {
				Object[] o = new Object[6];
				o[0] = i.getName().toString();
				o[3]= i.getPatients().size();
				if (i.getClass()==new InpatientDepartment("",5).getClass() ) {
					o[1]="yes";
					o[2]="no";
					o[4]= ((InpatientDepartment)i).getBed().size();
					o[5]= ((InpatientDepartment)i).occupiedBeds();
					
					
				}
				else {
					o[1]="no";
					o[2]="yes";
					o[4]= "-";
					o[5]= "-";
				}
				
			}
			tbl = new JTable(d);
			fireTableDataChanged();
			
			
			
			
			break;
		case "Staff":
			
			break;
		case "Patients":
			
			break;
			
		default:
			
			break;
		}
		
	}
	

}
