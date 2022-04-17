package com.RBsuccess.chatapp.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.RBsuccess.chatapp.utiles.ConfigReader;

public class Client {
	Socket socket ;
	public Client() throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORT"));
		socket = new Socket(ConfigReader.getValue("IP"), PORT);
		System.out.println("Client Comes");
		System.out.println("Enter the Message Send to the Server.....");
		Scanner scanner= new Scanner(System.in);
		String message = scanner.nextLine();
		OutputStream out = socket.getOutputStream(); // Write Bytes on Network
		out.write(message.getBytes());
		System.out.println("Message Send to the Server");
		scanner.close();
		out.close();
		socket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();

	}

}
