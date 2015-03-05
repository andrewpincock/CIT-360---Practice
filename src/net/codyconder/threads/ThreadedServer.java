package net.codyconder.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import net.codyconder.beans.carbean.OwnerBean;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class ThreadedServer {

	private static int port = 9889;
	
	public static void main(String[] args) {
		ServerSocket listeningSocket;
		try {
			listeningSocket = new ServerSocket(port);
			Socket clientSocket;
			
			while(true) {
				clientSocket = listeningSocket.accept();
				SocketServer conn = new SocketServer(clientSocket);
				
				Thread t = new Thread(conn);
				t.start();
			}
		} catch (IOException e){
			System.out.println("IOException on socket listen: " + e);
		}

	}

}


class SocketServer implements Runnable {
	private Socket clientSocket;
	
	SocketServer(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		JSONInputStream inFromClient;
		JSONOutputStream outToClient;
		try {
			inFromClient = new JSONInputStream(clientSocket.getInputStream());
			outToClient = new JSONOutputStream(clientSocket.getOutputStream());
			
			@SuppressWarnings("unchecked")
			// Read the OwnerBean into a HashMap
			HashMap<String, ?> parsedJSONMap = (HashMap<String, ?>) inFromClient.readObject();
			System.out.println("Object read");
			
			// Create a new OwnerBean
			OwnerBean theOwner = new OwnerBean(parsedJSONMap);

			// Send a success message back to the client
			String message = "The owner has been created successfully.";
			outToClient.writeObject(message);
			
			// Print out the owner details on our side
			System.out.println("The owner is " + theOwner.getFirstName() + " " 
					+ theOwner.getLastName() + ", a " + theOwner.getGender() + ".");
		} catch (JSONException e) {
			// This catches the exception thrown if we receive an invalid JSON string or a null object.
			System.out.println("Server: An invalid JSON string was received. Resetting connection.");
			// At this point, we'd send an error back to the client... however, it has likely crashed.
		} catch (ClassCastException e) {
			// This takes care of the issue if we receive something that's not an OwnerBean.
			System.out.println("Server: An invalid object was received. Resetting connection.");
			// At this point, we'd send an error back to the client... however, it has likely crashed.
		} catch (NullPointerException e) {
			// This appears to happen when we send something other than an OwnerBean
			System.out.println("Server: The server is only configured to handle OwnerBeans. Resetting connection.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}