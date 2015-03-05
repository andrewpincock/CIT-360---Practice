package net.codyconder.clientserver;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import net.codyconder.beans.carbean.OwnerBean;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/* 
 * This is the happy client.
 * The client sends a JSON string representing an OwnerBean
 * The server will convert this to a HashMap and create an OwnerBean object on its end.
 */

public class HappyClient {

	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		// -------------------------------------------------------------------------------------- //
		// The various println statements indicate where we are in the execution of the program.  //
		// -------------------------------------------------------------------------------------- //
		
		// Create an owner
		OwnerBean anOwner = new OwnerBean(1, "Kymberly", "Oliver", "female");
		
		// Open our connection with the server
		Socket toServer = null;
		try {
			toServer = new Socket("localhost", 9889);
		} catch (ConnectException e) {
			System.out.println("Exiting: The server refused the connection. Are you sure it's running?");
			System.exit(1);
		}
		
		// Set up our JSON streams so we can send and receive data
		JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		
		// Write the OwnerBean to the server
		outToServer.writeObject(anOwner);
		
		// Print the response from the server
		System.out.println(inFromServer.readObject());
		
		// Close the connection with the server
		toServer.close();
		System.out.println("Connection closed");

	}
	
}