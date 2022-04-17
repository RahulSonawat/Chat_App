package com.RBsuccess.chatapp.views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.RBsuccess.chapapp.dto.UserDTO;
import com.RBsuccess.chatapp.dao.UserDAO;
import com.RBsuccess.chatapp.utiles.ConfigReader;
import com.RBsuccess.chatapp.utiles.Encryption;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class forgetWindow extends JFrame {

	private JPanel contentPane;
	private JTextField EmailField;
	private JTextField AnswerField;

	
	static String ques;
	String[] nameString=ConfigReader.getValue("QUESTIONS").split("\\.");
	private JPasswordField passwordField;
	UserDAO userDAO =new UserDAO();
	
	private void checkDetails()
	{
	String emailString=EmailField.getText();
	//String answerString=Encryption.getEncryption(AnswerField.getText());
	String answerString=AnswerField.getText();
	String questionString=ques;
	UserDTO userDTO =new UserDTO(emailString, questionString, answerString);
	try {		
		boolean result= userDAO.isvalid(userDTO);
		if(result)
		{
			JOptionPane.showMessageDialog(this, "Information Matched \n Enter New Password");
			passwordField.setEnabled(true);	
		}
		else {
			JOptionPane.showMessageDialog(this, "Not Matched!");
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
	private void setNewPassword() {
		String emailString=EmailField.getText();
		String answerString=AnswerField.getText();
		String questionString=ques;
		char[] Npass=passwordField.getPassword();	
		UserDTO userDTO=new UserDTO(Npass,questionString,answerString,emailString);
			try {
			int result = userDAO.changePass(userDTO);
			if(result>0)
			{
				JOptionPane.showMessageDialog(this, "Password Changed!!");
				setVisible(false);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(this,"Password Not Changed!!");
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
		
		
		
		
		
	}
	public forgetWindow() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 537);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Viner Hand ITC", Font.PLAIN, 10));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email-ID");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(161, 72, 136, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelectSecurityQuestion = new JLabel("Security Question");
		lblSelectSecurityQuestion.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblSelectSecurityQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectSecurityQuestion.setBounds(161, 136, 194, 29);
		contentPane.add(lblSelectSecurityQuestion);
		
		JLabel lblNewLabel_1_1 = new JLabel("Answer");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(171, 229, 126, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("New Password");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 19));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(161, 376, 194, 29);
		contentPane.add(lblNewLabel_1_2);
		
		EmailField = new JTextField();
		EmailField.setBackground(new Color(240, 255, 240));
		EmailField.setBounds(462, 81, 96, 19);
		contentPane.add(EmailField);
		EmailField.setColumns(10);
		
		AnswerField = new JTextField();
		AnswerField.setBackground(new Color(240, 255, 240));
		AnswerField.setColumns(10);
		AnswerField.setBounds(462, 238, 96, 19);
		contentPane.add(AnswerField);
		
		JComboBox <String> comboBox = new JComboBox<>();
		comboBox.setForeground(new Color(240, 255, 240));
		comboBox.setBackground(new Color(240, 255, 240));
		comboBox.setBounds(462, 144, 219, 21);
		for(int i=0;i<nameString.length;i++)
		{
		comboBox.addItem(nameString[i]);
		}
		contentPane.add(comboBox);
		
		JButton VerifyBTN = new JButton("VERIFY");
		VerifyBTN.setBackground(new Color(255, 228, 225));
		VerifyBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkDetails();
			}
		});
		VerifyBTN.setFont(new Font("Verdana", Font.ITALIC, 15));
		VerifyBTN.setBounds(404, 314, 154, 21);
		contentPane.add(VerifyBTN);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(240, 255, 240));
		passwordField.setEditable(true);
		passwordField.setEnabled(false);
		passwordField.setBounds(462, 385, 219, 19);
		contentPane.add(passwordField);
		
		JButton SubmitBTN = new JButton("Submit");
		SubmitBTN.setBackground(new Color(255, 228, 225));
		SubmitBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewPassword();
			}
		});
		SubmitBTN.setFont(new Font("Verdana", Font.ITALIC, 19));
		SubmitBTN.setBounds(451, 444, 141, 21);
		contentPane.add(SubmitBTN);
		
		JButton questionConfirmBTN = new JButton("Confirm");
		questionConfirmBTN.setForeground(new Color(0, 0, 0));
		questionConfirmBTN.setBackground(new Color(255, 228, 225));
		questionConfirmBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ques=comboBox.getItemAt(comboBox.getSelectedIndex());
			}
		});
		questionConfirmBTN.setFont(new Font("Verdana", Font.ITALIC, 15));
		questionConfirmBTN.setBounds(752, 144, 106, 21);
		contentPane.add(questionConfirmBTN);
	}
}