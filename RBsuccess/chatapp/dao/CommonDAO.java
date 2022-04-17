package com.RBsuccess.chatapp.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.RBsuccess.chatapp.utiles.ConfigReader;

import static com.RBsuccess.chatapp.utiles.ConfigReader.getValue;;

interface  CommonDAO {
static public Connection createConnection() throws ClassNotFoundException, SQLException {
	// Step1:- Load a Driver which means load the class in which driver is present. and in the left side in the Referenced Libraries we see there is a class name com.mysql.cj.jdbc in which there is a driver class. so we need to import this class.
	Class.forName(ConfigReader.getValue("DRIVER"));
	// Step 2:- Making a connection and to make the connection we use a Interface called Connection and inside that there is a class called DriverManager and we it's method getConnection, in which we have to give the URL
	final String CONNECTION_STRING=ConfigReader.getValue("CONNECTION_URL");
	final String userid=ConfigReader.getValue("USER_ID");
	final String password=ConfigReader.getValue("PASSWORD");
	
	Connection con = DriverManager.getConnection(CONNECTION_STRING,userid,password);
	if(con!=null)
	{
		System.out.println("Finally you did it.....");
		
	}
	
	return con;
}

}
