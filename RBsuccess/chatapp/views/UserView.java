package com.RBsuccess.chatapp.views;

import javax.swing.JFrame;

public class UserView extends JFrame {
	public UserView() {
		
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(700,400);
			setResizable(false);
			setLocationRelativeTo(null);
			setTitle("Login");
			setVisible(true);
	}
public static void main(String[] args) {
	UserView userView =new UserView();
}	
}
