package net.codyconder.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import net.codyconder.beans.carbean.OwnerBean;

public class SocketServer {

	public static void main(String[] args) throws IOException, JSONException {
		while (true) {
			ServerSocket listeningSocket = new ServerSocket(9889);
			System.out.println("Listening...");
			Socket clientSocket = listeningSocket.accept();
			System.out.println("Connection made");

			JSONInputStream inFromClient = new JSONInputStream(
					clientSocket.getInputStream());
			JSONOutputStream outToClient = new JSONOutputStream(
					clientSocket.getOutputStream());
			
			System.out.println("Streams set up");
			try {
				@SuppressWarnings("unchecked")
				HashMap<String, ?> parsedJSONMap = (HashMap<String, ?>) inFromClient
						.readObject();
				
				System.out.println("Object read");
				OwnerBean theOwner = new OwnerBean(parsedJSONMap);

				String message = "The owner has been created successfully.";

				outToClient.writeObject(message);

				System.out.println("The owner is " + theOwner.getFirstName() + " "
						+ theOwner.getLastName() + ".");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				System.out.println("An invalid JSON string was received. Resetting connection.");
			}

			listeningSocket.close();
		}

	}

}
