package com.RBsuccess.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;

import javax.security.auth.login.LoginContext;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.RBsuccess.chapapp.dto.UserDTO;
import com.RBsuccess.chatapp.dao.UserDAO;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserScreen extends JFrame {
	private JTextField userName;
	private JPasswordField passwordField;

	public static void main(String[] args) {		
					UserScreen window = new UserScreen();					
			}
		
	UserDAO userDAO =new UserDAO();
	
	private void register() {
		Register_Window rgWindow =new Register_Window();
		rgWindow.setVisible(true);

	}
	private void  forgetpassword()
	{
		forgetWindow forgetwindow=new forgetWindow();
		forgetwindow.setVisible(true);
	}
	private void doLogin()
	{
		String userid=userName.getText();
		char[] password=passwordField.getPassword();
		UserDTO userDTO=new UserDTO(userid, password);
		
		try {
			boolean result =userDAO.isLogin(userDTO);
			if(result)
			{
				String message="Welcome "+(userid.toUpperCase());
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose();
				Dashboard dashboard =  new Dashboard(message);
				dashboard.setVisible(true);
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Incorrect Username or Password!");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
		System.out.println("Some DB issue");
		}
		catch(Exception e)
		{
		System.out.println("Some Generic Issue");
		}
	}
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 41));
		lblNewLabel.setBounds(256, 47, 296, 68);
		getContentPane().add(lblNewLabel);
		
		JLabel userIDlbl = new JLabel("UserName");
		userIDlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userIDlbl.setBounds(221, 163, 103, 31);
		getContentPane().add(userIDlbl);
		
		userName = new JTextField();
		userName.setBounds(365, 168, 268, 29);
		getContentPane().add(userName);
		userName.setColumns(10);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdlbl.setBounds(221, 242, 103, 31);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(365, 247, 268, 29);
		getContentPane().add(passwordField);
		
		JButton loginBT = new JButton("Login");
		loginBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginBT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginBT.setBounds(278, 345, 116, 37);
		getContentPane().add(loginBT);
		
		JButton registerBT = new JButton("Register");
		registerBT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerBT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registerBT.setBounds(476, 345, 116, 37);
		getContentPane().add(registerBT);
		
		JButton btnForgetPassword = new JButton("Forget Password?");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forgetpassword();
			}
		});
		btnForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnForgetPassword.setBounds(640, 351, 169, 31);
		getContentPane().add(btnForgetPassword);
		setForeground(Color.WHITE);
		setBounds(100, 100, 863, 438);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
