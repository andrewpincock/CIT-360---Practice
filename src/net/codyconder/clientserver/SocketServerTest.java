package net.codyconder.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import net.codyconder.beans.carbean.OwnerBean;

public class SocketServerTest {

	public static void main(String[] args) throws IOException, JSONException {
		ServerSocket listeningSocket = new ServerSocket(9889);
		System.out.println("Listening...");
		Socket clientSocket = listeningSocket.accept();
		
		JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
		JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());
		
		@SuppressWarnings("unchecked")
		HashMap<String, ?> parsedJSONMap = (HashMap<String, ?>) inFromClient.readObject();
		
		OwnerBean theOwner = new OwnerBean(parsedJSONMap);
		
		String message = "The owner has been created successfully.";
		
		outToClient.writeObject(message);
		
		System.out.println("The owner is " + theOwner.getFirstName() + " " + theOwner.getLastName() + ".");
		
		listeningSocket.close();

	}

}
