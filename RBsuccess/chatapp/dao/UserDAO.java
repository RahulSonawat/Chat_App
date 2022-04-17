package com.RBsuccess.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.RBsuccess.chatapp.utiles.Encryption;
import java.sql.SQLException;
import java.sql.Statement;
import com.RBsuccess.chapapp.dto.UserDTO;


// This class perform the CRUD(Create,Read,Update,Delete) Operations in the database.this will send the data to the MySQL database. Whole data is stored in the UserDTO class and this class will use data from that (UserDTO) class. So we can say that UserDTO class is for storing the data and it will act as in intermediate storage between the UserScreen and database.
public class UserDAO
{
	
	public boolean isLogin(UserDTO userdto) throws SQLException, ClassNotFoundException,Exception
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String sql="select userid from users where userid=? and password=?";
		try {
			connection=CommonDAO.createConnection();
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, userdto.getUserid());
			pstmt.setString(2, Encryption.getEncryption(new String(userdto.getPassword())));
			rs=pstmt.executeQuery();
			return rs.next();	
			
		}
		finally {
				if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(connection!=null)
				connection.close();		
			//select userid from users where email='qwe' and answer='qwe' and security_Question='What is your name?';
			//select userid from users where email='qwe' and security_Question='What is you name?' and answer='qwe';
			
		}
	}
	public boolean isvalid(UserDTO userDTO) throws SQLException, ClassNotFoundException
	
	{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String sql="select userid from users where email=? and answer=? and security_Question=?";
		try {
			connection=CommonDAO.createConnection();
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, userDTO.getEmail());
			pstmt.setString(3, userDTO.getQues());
			pstmt.setString(2,userDTO.getAnswer());
			rs=pstmt.executeQuery();
			return rs.next();	
			
		}
		finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(connection!=null)
				connection.close();		
				
			
		}
		
	}
	public int changePass(UserDTO userDTO) throws SQLException, ClassNotFoundException
	{
		Connection connection=null;
		Statement stmt=null;
		try {
			connection= CommonDAO.createConnection();
			stmt=connection.createStatement();
			
			int record =stmt.executeUpdate("update users set password='"+Encryption.getEncryption(new String(userDTO.getPassword()))+"' where email='"+userDTO.getEmail()+"'  and security_Question='"+userDTO.getQues()+"' and answer='"+userDTO.getAnswer()+"' ;");
			
			
			return record;		
		}

	
	finally {//Whether exception occur or not this will always run
		if(stmt!=null)
		stmt.close();
		if(connection!=null)
		connection.close();
	}
	}
	public int add(UserDTO userdto) throws ClassNotFoundException, SQLException
{ 
	Connection connection=null;					//This is used for making the connection with the MySQL database
	Statement stmt=null;
												//This is used for making the Queries
	try {//Guarded Region
	connection=CommonDAO.createConnection();	//Step 1 is to create the connection and connection is formed using the CommonDAO class
												//Step2:- Now we have to write the Query that will go to the DB and our data will be added there in the respective Columns.
												//Sample Query is:- insert into users(userid,password) values('rahul','rahul3360');
	stmt=connection.createStatement();
	
	//insert into users(userid,City,State,email,Phone_Number,password) values('rahul','rahul3360');
	//this statement return 1 if data is added and 0 is failed to add to add the data
	int record =stmt.executeUpdate("insert into users(userid,password,salary,City,State,email,Phone_Number,security_Question,answer) values('"+userdto.getUserid()+"','"+Encryption.getEncryption(new String(userdto.getPassword()))+"','"+userdto.getSalary()+"','"+userdto.getCity()+"','"+userdto.getState()+"','"+userdto.getEmail()+"','"+userdto.getPhoneNumber()+"','"+userdto.getQues()+"','"+userdto.getAnswer()+"');");
	
	return record;
	
	}
	finally {//Whether exception occur or not this will always run
		if(stmt!=null)
		stmt.close();
		if(connection!=null)
		connection.close();
	}
	
}

}
