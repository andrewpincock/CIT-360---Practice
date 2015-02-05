package net.codyconder.clientserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.quickconnectfamily.json.JSONException;
// import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

/*
 * This tests to see what happens when we send an empty string to the server.
 * The server will throw an exception (which is handled).
 * The client will then close the connection, thus preventing a crash.
 */

public class EmptyStringClient {

	public static void main(String[] args) throws UnknownHostException, IOException, JSONException {
		// -------------------------------------------------------------------------------------- //
		// The various println statements indicate where we are in the execution of the program.  //
		// -------------------------------------------------------------------------------------- //
		
		// Establish a connection with the server
		// and set a timeout so we don't sit here waiting forever (5 seconds)
		Socket toServer = new Socket("127.0.0.1", 9889);
		toServer.setSoTimeout(5000);
		System.out.println("Connection made");
		
		// Set up our JSON output stream.
		// There is no point in setting up an input stream, since we won't hear back from the server.
		// JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
		JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
		System.out.println("Streams set up");
		
		// Write our empty string to the server
		outToServer.writeObject("");
		System.out.println("Client: Empty string sent");
		
		// The server won't respond until after the connection is closed
		//System.out.println(inFromServer.readObject());
		
		// Close our connection and allow the server to continue.
		// This prevents the client from crashing as well.
		toServer.close();
		System.out.println("Connection closed");
	}

}
