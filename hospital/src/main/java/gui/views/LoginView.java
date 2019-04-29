package gui.views;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.controller.LoginController;
import gui.utils.GridBagLayoutUtils;

public class LoginView extends JFrame implements IError {

	private static final long serialVersionUID = 8981053836072595592L;
	
	private JButton btnLogin;
	private JTextField txtLogin;
	private LoginController controller;
	
	public LoginView(LoginController controller) {
		this.controller=controller;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Login");
		setLayout(new GridBagLayout());
		
		this.txtLogin=new JTextField(15);
		this.btnLogin= new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.validateCredentials(txtLogin.getText());
			}
		});
		
		add(new JLabel("Username:"), GridBagLayoutUtils.constraint(0, 0, 5));
		add(txtLogin, GridBagLayoutUtils.constraint(1, 0, 5));
		add(btnLogin, GridBagLayoutUtils.constraint(1, 2, 5));
		
		pack();
		setLocationRelativeTo(null);
		
		
		
	}

	public void showError() {
		JOptionPane.showMessageDialog(this, "UserId not found", "Login error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	
}
