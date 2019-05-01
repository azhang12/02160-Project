package gui.controller;

import org.junit.Test;

import gui.model.Data;
import gui.model.Session;
import gui.views.DataView;

public class DataTest {
	
	@Test
	public void testDataView() {
		ApplicationController app = new ApplicationController();
		Data data = new Data();
		Session session = new Session();
		
		DataController controller = new DataController(app,data,session);
		
		DataView test = new DataView(controller);
		test.setVisible(true);
		
		int k =0;
		k=k*k;
		
	}

}
