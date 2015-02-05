package net.codyconder.clientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import net.codyconder.beans.carbean.OwnerBean;

/* 
 * This is a simple server.
 * It expects a JSON string and converts it to an OwnerBean.
 * The server is configured to run in an infinite loop.
 * The server is also configured to handle all the errors it has experienced through my testing so far without crashing.
 * The various client files demonstrate different things that the client could send. Most of them are not happy ;)
 */

public class SocketServer {

	public static void main(String[] args) throws IOException, JSONException {
		while (true) {
			// -------------------------------------------------------------------------------------- //
			// The various println statements indicate where we are in the execution of the program.  //
			// -------------------------------------------------------------------------------------- //
			
			// Create a server socket to listen on port 9889
			ServerSocket listeningSocket = new ServerSocket(9889);
			System.out.println("Listening...");
			Socket clientSocket = listeningSocket.accept();
			System.out.println("Connection made");

			// Set up our JSON input and output streams
			JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
			JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());
			System.out.println("Streams set up");
			
			// The operation used to read the OwnerBean object is surrounded in a try/catch block.
			// We will catch various exceptions that we might encounter in order to keep the server up and running.
			try {
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
				// This appears to happen when we send a CarBean
				System.out.println("Server: The server is only configured to handle OwnerBeans. Resetting connection.");
			}
			
			// Close the connection with the client.
			// The loop will repeat and we will open up another listening socket.
			listeningSocket.close();
		}

	}

}
