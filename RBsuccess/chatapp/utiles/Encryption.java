package com.RBsuccess.chatapp.utiles;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
public static String getEncryption(String pass)
{
	try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] messageDigest = md.digest(pass.getBytes());
		 BigInteger no = new BigInteger(1, messageDigest);
		 String hashtext = no.toString(16);
         while (hashtext.length() < 32) {
             hashtext = "0" + hashtext;
         }
         return hashtext;
	}
	catch (NoSuchAlgorithmException e) {
		System.out.println("algorithm problem!");
	}
	return pass;
		
}
}
