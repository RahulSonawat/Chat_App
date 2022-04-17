package com.RBsuccess.chatapp.utiles;

import java.util.ResourceBundle;

public class ConfigReader {
	 
	ConfigReader() {}
 
	private static final ResourceBundle rb = ResourceBundle.getBundle("config");
 
	 public static String  getValue(String value)
	 {
		 return rb.getString(value);
	 }
 
}
