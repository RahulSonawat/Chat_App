package com.RBsuccess.chatapp.views;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.RBsuccess.chapapp.dto.UserDTO;
import com.RBsuccess.chatapp.dao.UserDAO;
import com.RBsuccess.chatapp.utiles.ConfigReader;
import com.RBsuccess.chatapp.utiles.Encryption;
import com.mysql.cj.xdevapi.Schema.Validation;

import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Register_Window extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JTextField emailfield;
	private JTextField phonenumberField;
	private JTextField cityField;
	private JTextField stateField;
	private JPasswordField passwordField;	
private void register() throws ClassNotFoundException, SQLException
{
	String useridString=userid.getText();
	String email=emailfield.getText();
	String phoneNoString=phonenumberField.getText();
	String city=cityField.getText();
	String state=stateField.getText();
	char[] password=passwordField.getPassword();
	String question=ques;
	String answerString=answerField.getText();
	
	if(question.isEmpty()||answerString.isEmpty()||useridString.isEmpty() || email.isEmpty() || phoneNoString.isEmpty() || city.isEmpty() || state.isEmpty() || new String(password).isEmpty())
	{
		JOptionPane.showMessageDialog(this,"EMPTY FIELDS NOT ACCEPTED!!");
		userid.setText(null);
		emailfield.setText(null);
		phonenumberField.setText(null);
		cityField.setText(null);
		stateField.setText(null);
		passwordField.setText(null);
		answerField.setText(null);
	}	
	else {
	
	UserDTO userDTO =new UserDTO(useridString, phoneNoString,city,state,password,email,question,answerString);	
	UserDAO userDAO =new UserDAO();	
	try {
		int result =userDAO.add(userDTO);
		if(result>0)
		{
			JOptionPane.showMessageDialog(this, "Register Successfully!!");
		}
		else {
			JOptionPane.showMessageDialog(this,"Registration Failed!!");
		}
		}catch(ClassNotFoundException | SQLException ex)
		
		{
			System.out.println("Some DB issue.....");
			ex.printStackTrace();//Tell from where the Exception is occurred.
		}
		catch(Exception e)
		{
			System.out.println("Some Generic Exceptioon");
			e.printStackTrace();
		}
	setVisible(false);
	dispose();
	 }	
}
private JTextField answerField;
String ques;
String[] nameString=ConfigReader.getValue("QUESTIONS").split("\\.");
	public Register_Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1113, 876);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Name = new JLabel("Name");
		Name.setHorizontalAlignment(SwingConstants.CENTER);
		Name.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Name.setBounds(181, 90, 66, 27);
		contentPane.add(Name);
		
		userid = new JTextField();
		userid.setBounds(453, 94, 226, 27);
		contentPane.add(userid);
		userid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-Mail");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(181, 183, 77, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(143, 246, 153, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("City");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(143, 317, 136, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("State");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(153, 399, 115, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(143, 460, 136, 27);
		contentPane.add(lblNewLabel_4);
		
		emailfield = new JTextField();
		emailfield.setColumns(10);
		emailfield.setBounds(453, 170, 226, 27);
		contentPane.add(emailfield);
		
		phonenumberField = new JTextField();
		phonenumberField.setColumns(10);
		phonenumberField.setBounds(453, 246, 226, 27);
		contentPane.add(phonenumberField);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(453, 321, 226, 27);
		contentPane.add(cityField);
		
		stateField = new JTextField();
		stateField.setColumns(10);
		stateField.setBounds(453, 401, 226, 27);
		contentPane.add(stateField);
		
		JLabel lblNewLabel_5 = new JLabel("REGISTRATION");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_5.setBounds(361, 21, 317, 41);
		contentPane.add(lblNewLabel_5);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					register();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(459, 694, 186, 27);
		contentPane.add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(453, 468, 226, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("Security Question");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_6.setBounds(167, 556, 178, 27);
		contentPane.add(lblNewLabel_6);
		
		
		
		JComboBox<String> comboBox = new JComboBox<>(nameString);
		comboBox.setBounds(459, 560, 214, 27);	
		contentPane.add(comboBox);
		ques=(String) comboBox.getSelectedItem();
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Answer");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_7.setBounds(181, 636, 153, 23);
		contentPane.add(lblNewLabel_7);
		
		answerField = new JTextField();
		answerField.setBounds(463, 642, 216, 19);
		contentPane.add(answerField);
		answerField.setColumns(10);
		
		JButton QuestionBtn = new JButton("Select");
		QuestionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ques=comboBox.getItemAt(comboBox.getSelectedIndex());
			}
		});
		QuestionBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		QuestionBtn.setBounds(766, 563, 85, 21);
		contentPane.add(QuestionBtn);
	}
}